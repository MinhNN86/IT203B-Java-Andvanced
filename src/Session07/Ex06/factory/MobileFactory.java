package Session07.Ex06.factory;

import Session07.Ex06.factory.*;
import Session07.Ex06.discount.*;
import Session07.Ex06.payment.*;
import Session07.Ex06.notification.*;
import Session07.Ex06.service.*;

public class MobileFactory implements SalesChannelFactory {

    public DiscountStrategy createDiscount() {
        return new MobileDiscount();
    }

    public PaymentMethod createPayment() {
        return new MomoPayment();
    }

    public NotificationService createNotification() {
        return new PushNotification();
    }
}
