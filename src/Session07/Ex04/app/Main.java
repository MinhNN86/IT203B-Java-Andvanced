package Session07.Ex04.app;

import Session07.Ex04.model.*;
import Session07.Ex04.repository.*;
import Session07.Ex04.notification.*;
import Session07.Ex04.service.*;

public class Main {
    public static void main(String[] args) {
        // Cấu hình 1
        OrderRepository repo1 = new FileOrderRepository();
        NotificationService noti1 = new EmailService();

        OrderService service1 = new OrderService(repo1, noti1);
        service1.createOrder(new Order("ORD001"));


        System.out.println("--------------------");


        // Cấu hình 2 (không sửa OrderService)
        OrderRepository repo2 = new DatabaseOrderRepository();
        NotificationService noti2 = new SMSNotification();

        OrderService service2 = new OrderService(repo2, noti2);
        service2.createOrder(new Order("ORD002"));
    }
}
