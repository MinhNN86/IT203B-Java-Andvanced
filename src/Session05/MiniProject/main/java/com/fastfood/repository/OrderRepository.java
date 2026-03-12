package Session05.MiniProject.main.java.com.fastfood.repository;

import Session05.MiniProject.main.java.com.fastfood.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Lưu trữ danh sách đơn hàng trong bộ nhớ (ArrayList).
 */
public class OrderRepository {
    private final List<Order> orders = new ArrayList<>();

    public void save(Order order) {
        orders.add(order);
    }

    public void remove(String orderId) {
        orders.removeIf(o -> o.getOrderId().equals(orderId));
    }

    public Optional<Order> findById(String orderId) {
        return orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .findFirst();
    }

    public List<Order> findAll() {
        return new ArrayList<>(orders);
    }
}
