package Session07.Ex06.payment;

import Session07.Ex06.factory.*;
import Session07.Ex06.discount.*;
import Session07.Ex06.payment.*;
import Session07.Ex06.notification.*;
import Session07.Ex06.service.*;

public class CODPayment implements PaymentMethod {

    public void pay(double amount) {
        System.out.println("Thanh toán tiền mặt tại quầy");
    }
}
