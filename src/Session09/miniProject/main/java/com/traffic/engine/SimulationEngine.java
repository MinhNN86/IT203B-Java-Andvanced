package Session09.miniProject.main.java.com.traffic.engine;

import Session09.miniProject.main.java.com.traffic.entity.Vehicle;
import Session09.miniProject.main.java.com.traffic.entity.VehicleType;
import Session09.miniProject.main.java.com.traffic.exception.TrafficJamException;
import Session09.miniProject.main.java.com.traffic.pattern.factory.VehicleFactory;
import Session09.miniProject.main.java.com.traffic.pattern.state.GreenState;
import Session09.miniProject.main.java.com.traffic.pattern.state.TrafficLight;
import Session09.miniProject.main.java.com.traffic.util.LoggerUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Engine điều khiển toàn bộ hệ thống.
 *
 * Luồng hoạt động chính:
 * 1) start() bật cờ running và khởi tạo đèn xanh ban đầu.
 * 2) lightThread chạy State Pattern để đổi đèn theo chu kỳ.
 * 3) spawnThread sinh xe ngẫu nhiên và đẩy vào lane (queue chờ).
 * 4) dispatchThread lấy xe từ lane khi đèn xanh và submit vào thread pool.
 * 5) Mỗi Vehicle tự chạy run(), đi qua IntersectionManager (critical section).
 */
public class SimulationEngine {

    private ExecutorService executor;
    private TrafficLight trafficLight;
    private IntersectionManager manager;
    private Lane lane;

    private final List<Vehicle> vehicles = new ArrayList<>();
    private Thread lightThread;
    private Thread spawnThread;
    private Thread dispatchThread;
    // Đếm số lần queue đầy (xem như sự kiện kẹt xe).
    private int trafficJamCount = 0;

    private volatile boolean running = false;

    public SimulationEngine() {
        this.executor = Executors.newFixedThreadPool(20);
        this.trafficLight = new TrafficLight();
        this.manager = new IntersectionManager();
        this.lane = new Lane();
    }

    public void start() {

        // Cờ dùng chung cho mọi thread để điều khiển vòng đời mô phỏng.
        running = true;

        // init traffic light
        trafficLight.setState(new GreenState());

        // lightThread chỉ quản lý đèn, không trực tiếp xử lý vehicle.
        lightThread = new Thread(() -> {
            while (running) {
                trafficLight.changeState();
            }
        }, "traffic-light-thread");
        lightThread.setDaemon(true);
        lightThread.start();

        // spawnThread đóng vai trò producer: sinh xe và cho vào hàng chờ lane.
        spawnThread = new Thread(() -> {
            int count = 0;
            while (running && count < 100) {
                Vehicle v = VehicleFactory.createVehicle(manager);
                synchronized (vehicles) {
                    // Danh sách vehicles phục vụ thống kê cuối kỳ.
                    vehicles.add(v);
                }

                try {
                    lane.addVehicle(v);
                } catch (TrafficJamException e) {
                    // Lane đầy nghĩa là kẹt xe, tăng counter để báo cáo monitoring.
                    synchronized (this) {
                        trafficJamCount++;
                    }
                    LoggerUtils.log("Phát hiện kẹt xe: " + e.getMessage());
                }

                count++;

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }, "vehicle-spawn-thread");
        spawnThread.start();

        // dispatchThread đóng vai trò consumer: chỉ xả queue khi đèn xanh.
        dispatchThread = new Thread(() -> {
            while (running) {
                if ("GREEN".equals(trafficLight.getCurrentSignal())) {
                    Vehicle next = lane.pollVehicle();
                    if (next != null) {
                        // Vehicle nhận broadcast tín hiệu đèn cho các vòng xử lý kế tiếp.
                        trafficLight.registerObserver(next);

                        // ExecutorService giúp chạy nhiều Vehicle song song ổn định.
                        executor.submit(next);
                    }
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }, "lane-dispatch-thread");
        dispatchThread.start();
    }

    /**
     * Stop toàn bộ hệ thống
     */
    public void stop() {
        // Tắt cờ trước để các vòng lặp thread tự thoát an toàn.
        running = false;

        if (spawnThread != null) {
            spawnThread.interrupt();
        }
        if (dispatchThread != null) {
            dispatchThread.interrupt();
        }
        if (lightThread != null) {
            lightThread.interrupt();
        }

        // Ngắt tất cả task vehicle đang chạy trong thread pool.
        executor.shutdownNow();

        System.out.println("[Engine] All threads stopped.");
    }

    /**
     * Thống kê sử dụng Stream API
     */
    public void printStatistics() {
        int totalVehicles;
        long ambulance;
        long car;
        long bike;
        long truck;
        synchronized (vehicles) {
            // Khóa list để tránh ConcurrentModification khi thread spawn đang thêm xe.
            totalVehicles = vehicles.size();

            ambulance = vehicles.stream()
                    .filter(v -> v.getType() == VehicleType.AMBULANCE)
                    .count();

            car = vehicles.stream()
                    .filter(v -> v.getType() == VehicleType.CAR)
                    .count();

            bike = vehicles.stream()
                    .filter(v -> v.getType() == VehicleType.MOTORBIKE)
                    .count();

            truck = vehicles.stream()
                    .filter(v -> v.getType() == VehicleType.TRUCK)
                    .count();
        }

        System.out.println("Total vehicles: " + totalVehicles);

        System.out.println("Ambulance: " + ambulance);
        System.out.println("Car: " + car);
        System.out.println("Motorbike: " + bike);
        System.out.println("Truck: " + truck);
        System.out.println("Vehicles passed intersection: " + manager.getTotalPassedVehicles());
        System.out.println("Traffic jam events: " + getTrafficJamCount());
    }

    /**
     * Health check hệ thống
     */
    public void healthCheck() {
        if (!running) {
            System.out.println("System is NOT running");
            return;
        }

        if (executor.isShutdown()) {
            System.out.println("ThreadPool is DOWN!");
        } else {
            System.out.println("ThreadPool OK");
        }

        System.out.println("Signal: " + trafficLight.getCurrentSignal());
        synchronized (vehicles) {
            System.out.println("Vehicles active: " + vehicles.size());
        }
        System.out.println("Waiting in lane: " + lane.size());
        System.out.println("Traffic jams: " + getTrafficJamCount());
        System.out.println("System running normally");
    }

    private synchronized int getTrafficJamCount() {
        // Đồng bộ để kết quả nhất quán khi nhiều thread cùng truy cập counter.
        return trafficJamCount;
    }
}