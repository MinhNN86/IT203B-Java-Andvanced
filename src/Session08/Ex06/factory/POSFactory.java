package Session08.Ex06.factory;

import Session08.Ex06.discount.*;
import Session08.Ex06.payment.*;
import Session08.Ex06.notification.*;

public class POSFactory implements SalesChannelFactory {

    public DiscountStrategy createDiscountStrategy() {
        return new MemberDiscount();
    }

    public PaymentMethod createPaymentMethod() {
        return new CODPayment();
    }

    public NotificationService createNotificationService() {
        return new PrintReceipt();
    }
}
