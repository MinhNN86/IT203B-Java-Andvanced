package Session07.Ex06.factory;

import Session07.Ex06.factory.*;
import Session07.Ex06.discount.*;
import Session07.Ex06.payment.*;
import Session07.Ex06.notification.*;
import Session07.Ex06.service.*;

public class POSFactory implements SalesChannelFactory {

    public DiscountStrategy createDiscount() {
        return new StoreDiscount();
    }

    public PaymentMethod createPayment() {
        return new CODPayment();
    }

    public NotificationService createNotification() {
        return new PrintInvoiceNotification();
    }
}