package Session08.Ex06.factory;

import Session08.Ex06.discount.*;
import Session08.Ex06.payment.*;
import Session08.Ex06.notification.*;

public class WebsiteFactory implements SalesChannelFactory {

    public DiscountStrategy createDiscountStrategy() {
        return new WebsiteDiscount();
    }

    public PaymentMethod createPaymentMethod() {
        return new CreditCardPayment();
    }

    public NotificationService createNotificationService() {
        return new EmailNotification();
    }
}