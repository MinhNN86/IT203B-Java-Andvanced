package Session07.Ex01.repository;

import Session07.Ex01.model.*;
import Session07.Ex01.service.*;
import Session07.Ex01.repository.*;

public class OrderRepository {
    public void save(Order order) {
        System.out.println("Đã lưu đơn hàng " + order.getOrderId());
    }
}
