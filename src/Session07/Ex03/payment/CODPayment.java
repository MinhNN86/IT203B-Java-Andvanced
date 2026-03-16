package Session07.Ex03.payment;

import Session07.Ex03.contract.*;
import Session07.Ex03.payment.*;

public class CODPayment implements CODPayable{

    @Override
    public void processCOD(double amount) {
        System.out.println("Xử lý thanh toán COD: " + (long)amount + " VND");
    }

    @Override
    public void pay(double amount) {
        processCOD(amount);
    }
}
