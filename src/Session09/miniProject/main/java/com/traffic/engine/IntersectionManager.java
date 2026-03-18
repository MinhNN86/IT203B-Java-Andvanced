package Session09.miniProject.main.java.com.traffic.engine;

import Session09.miniProject.main.java.com.traffic.entity.Vehicle;
import Session09.miniProject.main.java.com.traffic.entity.VehicleType;
import Session09.miniProject.main.java.com.traffic.exception.CollisionException;
import Session09.miniProject.main.java.com.traffic.util.LoggerUtils;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Quản lý giao lộ (Critical Section)
 */
public class IntersectionManager {

    // Fair lock: xe vào giao lộ theo thứ tự chờ để giảm starvation.
    private final ReentrantLock lock = new ReentrantLock(true);
    private int totalPassedVehicles = 0;

    public void enterIntersection(Vehicle v) {
        // Critical section: mỗi thời điểm chỉ một xe được đi qua giao lộ.
        lock.lock();
        try {
            LoggerUtils.log(formatPassingMessage(v));
            Thread.sleep(100);
            incrementPassedCount();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new CollisionException("Interrupted while crossing: " + v.getId());
        } finally {
            lock.unlock();
        }
    }

    private synchronized void incrementPassedCount() {
        // Đồng bộ để bộ đếm chính xác khi nhiều thread cập nhật.
        totalPassedVehicles++;
    }

    public synchronized int getTotalPassedVehicles() {
        return totalPassedVehicles;
    }

    private String formatPassingMessage(Vehicle v) {
        String vehicleName;
        if (v.getType() == VehicleType.AMBULANCE) {
            vehicleName = "Xe cứu thương";
        } else if (v.getType() == VehicleType.CAR) {
            vehicleName = "Xe ô tô";
        } else if (v.getType() == VehicleType.TRUCK) {
            vehicleName = "Xe tải";
        } else {
            vehicleName = "Xe máy";
        }

        String[] idParts = v.getId().split("-");
        int sequence = 0;
        if (idParts.length > 1) {
            try {
                sequence = Integer.parseInt(idParts[idParts.length - 1]);
            } catch (NumberFormatException ignored) {
                sequence = 0;
            }
        }

        return String.format("%s #%02d đang đi qua ngã tư", vehicleName, sequence);
    }
}