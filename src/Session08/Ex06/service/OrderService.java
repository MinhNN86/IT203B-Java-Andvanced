package Session08.Ex06.service;

import Session08.Ex06.discount.*;
import Session08.Ex06.notification.*;
import Session08.Ex06.payment.*;
import Session08.Ex06.factory.*;

public class OrderService {

    private DiscountStrategy discountStrategy;
    private PaymentMethod paymentMethod;
    private NotificationService notificationService;

    public OrderService(SalesChannelFactory factory) {
        this.discountStrategy = factory.createDiscountStrategy();
        this.paymentMethod = factory.createPaymentMethod();
        this.notificationService = factory.createNotificationService();
    }

    public void processOrder(double price, int quantity) {

        double total = price * quantity;

        System.out.println("Tổng tiền: " + total);

        total = discountStrategy.applyDiscount(total);

        paymentMethod.pay(total);

        notificationService.notifyUser("Đơn hàng thành công");
    }
}
