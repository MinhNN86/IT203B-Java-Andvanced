package Session07.Ex02.discount;

import Session07.Ex02.discount.*;
import Session07.Ex02.service.*;

// Không giảm giá
public class NoDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount;
    }
}
