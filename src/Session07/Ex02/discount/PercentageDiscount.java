package Session07.Ex02.discount;

import Session07.Ex02.discount.*;
import Session07.Ex02.service.*;

// giảm theo %
public class PercentageDiscount implements DiscountStrategy {
    private double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount - (totalAmount * percent / 100);
    }
}
