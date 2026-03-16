package Session07.Ex02.discount;

import Session07.Ex02.discount.*;
import Session07.Ex02.service.*;

// giảm số tiền cố định
public class FixedDiscount implements DiscountStrategy {

    private double discountAmount;

    public FixedDiscount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount - discountAmount;
    }
}
