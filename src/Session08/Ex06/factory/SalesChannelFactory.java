package Session08.Ex06.factory;

import Session08.Ex06.discount.DiscountStrategy;
import Session08.Ex06.notification.NotificationService;
import Session08.Ex06.payment.PaymentMethod;

public interface SalesChannelFactory {

    DiscountStrategy createDiscountStrategy();

    PaymentMethod createPaymentMethod();

    NotificationService createNotificationService();
}
