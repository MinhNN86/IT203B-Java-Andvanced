package Session07.Ex05.repository;

import Session07.Ex05.model.*;
import Session07.Ex05.repository.*;
import Session07.Ex05.discount.*;
import Session07.Ex05.payment.*;
import Session07.Ex05.notification.*;
import Session07.Ex05.service.*;

import java.util.ArrayList;
import java.util.List;

public class FileOrderRepository implements OrderRepository {

    private List<Order> orders = new ArrayList<>();

    public void save(Order order) {
        orders.add(order);
        System.out.println("Đã lưu đơn hàng " + order.getId());
    }

    public List<Order> findAll() {
        return orders;
    }
}
