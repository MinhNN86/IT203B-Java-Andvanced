package Session07.Ex05.discount;

import Session07.Ex05.model.*;
import Session07.Ex05.repository.*;
import Session07.Ex05.discount.*;
import Session07.Ex05.payment.*;
import Session07.Ex05.notification.*;
import Session07.Ex05.service.*;

public class FixedDiscount implements DiscountStrategy {

    private double amount;

    public FixedDiscount(double amount) {
        this.amount = amount;
    }

    public double applyDiscount(double total) {
        return total - amount;
    }
}