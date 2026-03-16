package Session07.Ex06.discount;

import Session07.Ex06.factory.*;
import Session07.Ex06.discount.*;
import Session07.Ex06.payment.*;
import Session07.Ex06.notification.*;
import Session07.Ex06.service.*;

public class MobileDiscount implements DiscountStrategy {

    public double applyDiscount(double total) {
        System.out.println("Áp dụng giảm giá 15% cho lần đầu");
        return total * 0.85;
    }
}