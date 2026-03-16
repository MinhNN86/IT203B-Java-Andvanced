package Session07.Ex04.service;

import Session07.Ex04.model.*;
import Session07.Ex04.repository.*;
import Session07.Ex04.notification.*;
import Session07.Ex04.service.*;

public class OrderService {

    private OrderRepository repository;
    private NotificationService notificationService;

    public OrderService(OrderRepository repository,
                        NotificationService notificationService) {
        this.repository = repository;
        this.notificationService = notificationService;
    }

    public void createOrder(Order order) {

        repository.save(order);

        notificationService.send(
                "Đơn hàng " + order.getId() + " đã được tạo",
                "customer"
        );
    }
}
