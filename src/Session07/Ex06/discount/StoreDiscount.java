package Session07.Ex06.discount;

import Session07.Ex06.factory.*;
import Session07.Ex06.discount.*;
import Session07.Ex06.payment.*;
import Session07.Ex06.notification.*;
import Session07.Ex06.service.*;

public class StoreDiscount implements DiscountStrategy {

    public double applyDiscount(double total) {
        System.out.println("Giảm giá 5% cho thành viên tại cửa hàng");
        return total * 0.95;
    }
}