package Session07.Ex06.service;

import Session07.Ex06.factory.*;
import Session07.Ex06.discount.*;
import Session07.Ex06.payment.*;
import Session07.Ex06.notification.*;
import Session07.Ex06.service.*;

public class OrderService {

    private DiscountStrategy discount;
    private PaymentMethod payment;
    private NotificationService notification;

    public OrderService(SalesChannelFactory factory) {

        this.discount = factory.createDiscount();
        this.payment = factory.createPayment();
        this.notification = factory.createNotification();
    }

    public void createOrder(double total) {

        double finalAmount = discount.applyDiscount(total);

        payment.pay(finalAmount);

        notification.send("Order success");
    }
}
