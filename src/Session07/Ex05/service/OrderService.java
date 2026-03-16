package Session07.Ex05.service;

import Session07.Ex05.model.*;
import Session07.Ex05.repository.*;
import Session07.Ex05.discount.*;
import Session07.Ex05.payment.*;
import Session07.Ex05.notification.*;
import Session07.Ex05.service.*;

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
                order.getCustomer().getEmail()
        );
    }
}
