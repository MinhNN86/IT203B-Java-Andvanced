package Session08.Ex06.factory;

import Session08.Ex06.discount.*;
import Session08.Ex06.payment.*;
import Session08.Ex06.notification.*;

public class MobileAppFactory implements SalesChannelFactory {

    public DiscountStrategy createDiscountStrategy() {
        return new FirstTimeDiscount();
    }

    public PaymentMethod createPaymentMethod() {
        return new MomoPayment();
    }

    public NotificationService createNotificationService() {
        return new PushNotification();
    }
}
