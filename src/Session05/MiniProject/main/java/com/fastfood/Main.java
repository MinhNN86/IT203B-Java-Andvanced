package Session05.MiniProject.main.java.com.fastfood;

import Session05.MiniProject.main.java.com.fastfood.exception.InsufficientStockException;
import Session05.MiniProject.main.java.com.fastfood.exception.InvalidOrderIdException;
import Session05.MiniProject.main.java.com.fastfood.model.Drink;
import Session05.MiniProject.main.java.com.fastfood.model.Food;
import Session05.MiniProject.main.java.com.fastfood.model.MenuItem;
import Session05.MiniProject.main.java.com.fastfood.model.Order;
import Session05.MiniProject.main.java.com.fastfood.repository.MenuRepository;
import Session05.MiniProject.main.java.com.fastfood.repository.OrderRepository;
import Session05.MiniProject.main.java.com.fastfood.service.MenuService;
import Session05.MiniProject.main.java.com.fastfood.service.OrderService;
import Session05.MiniProject.main.java.com.fastfood.service.StatisticsService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

/**
 * Điểm vào chính của ứng dụng – điều hướng menu và gọi các service.
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final MenuRepository menuRepository = new MenuRepository();
    private static final OrderRepository orderRepository = new OrderRepository();
    private static final MenuService menuService = new MenuService(menuRepository);
    private static final OrderService orderService = new OrderService(orderRepository, menuService);
    private static final StatisticsService statisticsService = new StatisticsService(orderRepository);

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        loadSampleData();

        int choice;
        do {
            printMainMenu();
            choice = readInt();
            switch (choice) {
                case 1:
                    menuManagement();
                    break;
                case 2:
                    orderManagement();
                    break;
                case 3:
                    statisticsMenu();
                    break;
                case 4:
                    System.out.println("Hẹn gặp lại!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập 1–4.");
            }
        } while (choice != 4);

        scanner.close();
    }

    // =========================================================
    // DỮ LIỆU MẪU
    // =========================================================
    private static void loadSampleData() {
        menuService.addMenuItem(new Food("F001", "Hamburger Bò Phô Mai", 45000, 100, "Burger"));
        menuService.addMenuItem(new Food("F002", "Gà Rán Giòn", 35000, 150, "Gà"));
        menuService.addMenuItem(new Food("F003", "Khoai Tây Chiên", 20000, 200, "Món phụ"));
        menuService.addMenuItem(new Food("F004", "Pizza Hải Sản", 80000, 50, "Pizza"));
        menuService.addMenuItem(new Food("F005", "Cơm Gà Nướng", 40000, 80, "Cơm"));
        menuService.addMenuItem(new Drink("D001", "Coca Cola", 15000, 200, Drink.DrinkSize.M));
        menuService.addMenuItem(new Drink("D002", "Nước Cam Tươi", 20000, 150, Drink.DrinkSize.L));
        menuService.addMenuItem(new Drink("D003", "Trà Sữa Trân Châu", 30000, 100, Drink.DrinkSize.M));
        menuService.addMenuItem(new Drink("D004", "Sinh Tố Xoài", 25000, 80, Drink.DrinkSize.S));
    }

    // =========================================================
    // MENU CHÍNH
    // =========================================================
    private static void printMainMenu() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   HỆ THỐNG QUẢN LÝ CỬA HÀNG ĐỒ ĂN NHANH      ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║  1. Quản lý danh mục món ăn                  ║");
        System.out.println("║  2. Tạo và quản lý đơn hàng                  ║");
        System.out.println("║  3. Thống kê doanh thu & Tìm kiếm            ║");
        System.out.println("║  4. Thoát                                    ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.print("Chọn chức năng (1-4): ");
    }

    // =========================================================
    // 1. QUẢN LÝ DANH MỤC MÓN ĂN
    // =========================================================
    private static void menuManagement() {
        int choice;
        do {
            System.out.println("\n--- QUẢN LÝ DANH MỤC MÓN ĂN ---");
            System.out.println("1. Xem tất cả món ăn");
            System.out.println("2. Thêm đồ ăn mới (Food)");
            System.out.println("3. Thêm đồ uống mới (Drink)");
            System.out.println("4. Cập nhật thông tin món");
            System.out.println("5. Xóa món");
            System.out.println("6. Tìm kiếm theo tên");
            System.out.println("7. Lọc theo khoảng giá");
            System.out.println("0. Quay lại menu chính");
            System.out.print("Chọn: ");
            choice = readInt();

            switch (choice) {
                case 1:
                    listAllMenuItems();
                    break;
                case 2:
                    addFood();
                    break;
                case 3:
                    addDrink();
                    break;
                case 4:
                    updateMenuItem();
                    break;
                case 5:
                    deleteMenuItem();
                    break;
                case 6:
                    searchByName();
                    break;
                case 7:
                    filterByPrice();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    private static void listAllMenuItems() {
        List<MenuItem> items = menuService.getAllMenuItems();
        if (items.isEmpty()) {
            System.out.println("Danh sách món ăn trống.");
            return;
        }
        System.out.println("\n=== DANH SÁCH MÓN ĂN (" + items.size() + " món) ===");
        items.forEach(System.out::println);
    }

    private static void addFood() {
        System.out.println("\n--- Thêm Đồ Ăn Mới ---");
        System.out.print("ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Tên: ");
        String name = scanner.nextLine().trim();
        System.out.print("Giá (VND): ");
        double price = readDouble();
        System.out.print("Số lượng tồn kho: ");
        int stock = readInt();
        System.out.print("Danh mục (Burger / Pizza / Gà / ...): ");
        String category = scanner.nextLine().trim();

        try {
            menuService.addMenuItem(new Food(id, name, price, stock, category));
            System.out.println("✓ Đã thêm đồ ăn thành công!");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static void addDrink() {
        System.out.println("\n--- Thêm Đồ Uống Mới ---");
        System.out.print("ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Tên: ");
        String name = scanner.nextLine().trim();
        System.out.print("Giá gốc (VND): ");
        double price = readDouble();
        System.out.print("Số lượng tồn kho: ");
        int stock = readInt();
        System.out.println("Size (S / M / L)  →  S=x1.0 | M=x1.2 | L=x1.5");
        System.out.print("Chọn size: ");
        String sizeStr = scanner.nextLine().trim().toUpperCase();

        Drink.DrinkSize size;
        try {
            size = Drink.DrinkSize.valueOf(sizeStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Size không hợp lệ. Sử dụng M mặc định.");
            size = Drink.DrinkSize.M;
        }

        try {
            menuService.addMenuItem(new Drink(id, name, price, stock, size));
            System.out.println("✓ Đã thêm đồ uống thành công!");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static void updateMenuItem() {
        System.out.println("\n--- Cập Nhật Món Ăn ---");
        listAllMenuItems();
        System.out.print("Nhập ID món cần cập nhật: ");
        String id = scanner.nextLine().trim();

        Optional<MenuItem> opt = menuService.findById(id);
        if (!opt.isPresent()) {
            System.out.println("Không tìm thấy món với ID: " + id);
            return;
        }

        MenuItem item = opt.get();
        System.out.println("Đang sửa: " + item);

        System.out.print("Tên mới (Enter để giữ nguyên): ");
        String name = scanner.nextLine().trim();
        if (!name.isEmpty())
            item.setName(name);

        System.out.print("Giá mới – VND (Enter để giữ nguyên): ");
        String priceStr = scanner.nextLine().trim();
        if (!priceStr.isEmpty()) {
            try {
                double p = Double.parseDouble(priceStr);
                if (p >= 0)
                    item.setPrice(p);
            } catch (NumberFormatException e) {
                System.out.println("Giá không hợp lệ, giữ nguyên.");
            }
        }

        System.out.print("Số lượng tồn kho mới (Enter để giữ nguyên): ");
        String stockStr = scanner.nextLine().trim();
        if (!stockStr.isEmpty()) {
            try {
                int s = Integer.parseInt(stockStr);
                if (s >= 0)
                    item.setStock(s);
            } catch (NumberFormatException e) {
                System.out.println("Số lượng không hợp lệ, giữ nguyên.");
            }
        }

        try {
            menuService.updateMenuItem(item);
            System.out.println("✓ Cập nhật thành công!");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static void deleteMenuItem() {
        System.out.println("\n--- Xóa Món Ăn ---");
        listAllMenuItems();
        System.out.print("Nhập ID món cần xóa: ");
        String id = scanner.nextLine().trim();

        if (menuService.findById(id).isPresent()) {
            menuService.removeMenuItem(id);
            System.out.println("✓ Đã xóa món với ID: " + id);
        } else {
            System.out.println("Không tìm thấy món với ID: " + id);
        }
    }

    private static void searchByName() {
        System.out.print("\nNhập từ khóa tìm kiếm: ");
        String keyword = scanner.nextLine().trim();
        List<MenuItem> results = menuService.filterByName(keyword);
        if (results.isEmpty()) {
            System.out.println("Không tìm thấy món nào phù hợp với \"" + keyword + "\".");
        } else {
            System.out.println("Tìm thấy " + results.size() + " kết quả:");
            results.forEach(System.out::println);
        }
    }

    private static void filterByPrice() {
        System.out.print("Giá tối thiểu (VND): ");
        double min = readDouble();
        System.out.print("Giá tối đa    (VND): ");
        double max = readDouble();
        List<MenuItem> results = menuService.filterByPriceRange(min, max);
        if (results.isEmpty()) {
            System.out.printf("Không có món nào trong khoảng %,.0f – %,.0f VND.%n", min, max);
        } else {
            System.out.printf("Có %d món trong khoảng %,.0f – %,.0f VND:%n",
                    results.size(), min, max);
            results.forEach(System.out::println);
        }
    }

    // =========================================================
    // 2. QUẢN LÝ ĐƠN HÀNG
    // =========================================================
    private static void orderManagement() {
        int choice;
        do {
            System.out.println("\n--- QUẢN LÝ ĐƠN HÀNG ---");
            System.out.println("1. Tạo đơn hàng mới");
            System.out.println("2. Thêm món vào đơn hàng");
            System.out.println("3. Xóa món khỏi đơn hàng");
            System.out.println("4. Xem tất cả đơn hàng");
            System.out.println("5. Xem chi tiết đơn hàng");
            System.out.println("6. Thanh toán đơn hàng");
            System.out.println("7. Hủy đơn hàng");
            System.out.println("0. Quay lại menu chính");
            System.out.print("Chọn: ");
            choice = readInt();

            switch (choice) {
                case 1:
                    createNewOrder();
                    break;
                case 2:
                    addItemToOrder();
                    break;
                case 3:
                    removeItemFromOrder();
                    break;
                case 4:
                    listAllOrders();
                    break;
                case 5:
                    viewOrderDetail();
                    break;
                case 6:
                    payOrder();
                    break;
                case 7:
                    cancelOrder();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    private static void createNewOrder() {
        Order order = orderService.createOrder();
        System.out.println("✓ Đã tạo đơn hàng mới: " + order.getOrderId());
    }

    private static void addItemToOrder() {
        System.out.println("\n--- Thêm Món Vào Đơn Hàng ---");
        listAllOrders();
        System.out.print("ID đơn hàng: ");
        String orderId = scanner.nextLine().trim();

        listAllMenuItems();
        System.out.print("ID món: ");
        String menuId = scanner.nextLine().trim();
        System.out.print("Số lượng: ");
        int qty = readInt();

        try {
            orderService.addItemToOrder(orderId, menuId, qty);
            System.out.println("✓ Đã thêm món vào đơn hàng " + orderId + "!");
        } catch (InvalidOrderIdException | InsufficientStockException
                | IllegalArgumentException | IllegalStateException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static void removeItemFromOrder() {
        System.out.println("\n--- Xóa Món Khỏi Đơn Hàng ---");
        listAllOrders();
        System.out.print("ID đơn hàng: ");
        String orderId = scanner.nextLine().trim();

        try {
            Order order = orderService.getOrderById(orderId);
            System.out.println(order);
            System.out.print("ID món cần xóa: ");
            String menuId = scanner.nextLine().trim();
            orderService.removeItemFromOrder(orderId, menuId);
            System.out.println("✓ Đã xóa món khỏi đơn hàng!");
        } catch (InvalidOrderIdException | IllegalStateException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static void listAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        if (orders.isEmpty()) {
            System.out.println("Chưa có đơn hàng nào.");
            return;
        }
        System.out.println("\n=== DANH SÁCH ĐƠN HÀNG (" + orders.size() + " đơn) ===");
        System.out.printf("%-10s | %-12s | %s%n", "ID", "Trạng thái", "Tổng tiền");
        System.out.println("–".repeat(45));
        for (Order o : orders) {
            System.out.printf("%-10s | %-12s | %,.0f VND%n",
                    o.getOrderId(), o.getStatus(), o.getTotalPrice());
        }
    }

    private static void viewOrderDetail() {
        System.out.print("ID đơn hàng: ");
        String orderId = scanner.nextLine().trim();
        Optional<Order> opt = orderService.findOrderById(orderId);
        if (opt.isPresent()) {
            System.out.println("\n" + opt.get());
        } else {
            System.out.println("Không tìm thấy đơn hàng: " + orderId);
        }
    }

    private static void payOrder() {
        System.out.print("ID đơn hàng cần thanh toán: ");
        String orderId = scanner.nextLine().trim();
        try {
            Order order = orderService.getOrderById(orderId);
            System.out.println(order);
            System.out.printf("Tổng tiền: %,.0f VND  –  Xác nhận thanh toán? (y/n): ",
                    order.getTotalPrice());
            String confirm = scanner.nextLine().trim();
            if (confirm.equalsIgnoreCase("y")) {
                orderService.payOrder(orderId);
                System.out.println("✓ Thanh toán thành công!");
            } else {
                System.out.println("Đã hủy thao tác thanh toán.");
            }
        } catch (InvalidOrderIdException | IllegalStateException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static void cancelOrder() {
        System.out.print("ID đơn hàng cần hủy: ");
        String orderId = scanner.nextLine().trim();
        try {
            orderService.cancelOrder(orderId);
            System.out.println("✓ Đã hủy đơn hàng " + orderId + ". Tồn kho đã được hoàn lại.");
        } catch (InvalidOrderIdException | IllegalStateException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    // =========================================================
    // 3. THỐNG KÊ & TÌM KIẾM
    // =========================================================
    private static void statisticsMenu() {
        int choice;
        do {
            System.out.println("\n--- THỐNG KÊ & TÌM KIẾM ---");
            System.out.println("1. Tổng doanh thu");
            System.out.println("2. Doanh thu theo từng món");
            System.out.println("3. Số lượng bán theo từng món");
            System.out.println("4. Món bán chạy nhất");
            System.out.println("5. Top 5 món bán chạy");
            System.out.println("6. Tổng đơn hàng đã thanh toán");
            System.out.println("0. Quay lại menu chính");
            System.out.print("Chọn: ");
            choice = readInt();

            switch (choice) {
                case 1:
                    System.out.printf("Tổng doanh thu: %,.0f VND%n",
                            statisticsService.getTotalRevenue());
                    break;
                case 2:
                    printRevenueByItem();
                    break;
                case 3:
                    printSalesByItem();
                    break;
                case 4:
                    Optional<String> best = statisticsService.getBestSellingItem();
                    if (best.isPresent()) {
                        System.out.println("Món bán chạy nhất: " + best.get());
                    } else {
                        System.out.println("Chưa có dữ liệu bán hàng.");
                    }
                    break;
                case 5:
                    printTopSellingItems(5);
                    break;
                case 6:
                    System.out.println("Tổng đơn đã thanh toán: "
                            + statisticsService.getTotalPaidOrderCount() + " đơn");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    private static void printRevenueByItem() {
        Map<String, Double> revenue = statisticsService.getRevenueByItem();
        if (revenue.isEmpty()) {
            System.out.println("Chưa có dữ liệu doanh thu.");
            return;
        }
        System.out.println("\nDoanh thu theo món (từ đơn đã thanh toán):");
        System.out.printf("%-32s | %s%n", "Tên món", "Doanh thu (VND)");
        System.out.println("–".repeat(55));
        revenue.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(e -> System.out.printf("%-32s | %,.0f%n", e.getKey(), e.getValue()));
    }

    private static void printSalesByItem() {
        Map<String, Integer> sales = statisticsService.getSalesByItem();
        if (sales.isEmpty()) {
            System.out.println("Chưa có dữ liệu bán hàng.");
            return;
        }
        System.out.println("\nSố lượng bán theo món:");
        System.out.printf("%-32s | %s%n", "Tên món", "Số lượng");
        System.out.println("–".repeat(45));
        sales.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e -> System.out.printf("%-32s | %d%n", e.getKey(), e.getValue()));
    }

    private static void printTopSellingItems(int n) {
        List<Map.Entry<String, Integer>> top = statisticsService.getTopSellingItems(n);
        if (top.isEmpty()) {
            System.out.println("Chưa có dữ liệu.");
            return;
        }
        System.out.println("\nTop " + n + " món bán chạy:");
        int rank = 1;
        for (Map.Entry<String, Integer> e : top) {
            System.out.printf("  %d. %-30s – %d cái%n", rank++, e.getKey(), e.getValue());
        }
    }

    // =========================================================
    // TIỆN ÍCH ĐỌC INPUT AN TOÀN
    // =========================================================
    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Vui lòng nhập số nguyên hợp lệ: ");
            }
        }
    }

    private static double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Vui lòng nhập số hợp lệ: ");
            }
        }
    }
}
