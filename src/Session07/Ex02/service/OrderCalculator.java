package Session07.Ex02.service;

import Session07.Ex02.discount.*;
import Session07.Ex02.service.*;

public class OrderCalculator {

    private DiscountStrategy discountStrategy;

    public OrderCalculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateTotal(double totalAmount) {
        return discountStrategy.applyDiscount(totalAmount);
    }
}
