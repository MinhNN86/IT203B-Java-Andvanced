package Session07.Ex03.payment;

import Session07.Ex03.contract.*;
import Session07.Ex03.payment.*;

public class CreditCardPayment implements CardPayable{
    @Override
    public void processCreditCard(double amount) {
        System.out.println("Xử lý thanh toán thẻ tín dụng: " + (long)amount + " - Thành công");
    }

    @Override
    public void pay(double amount) {
        processCreditCard(amount);
    }
}
