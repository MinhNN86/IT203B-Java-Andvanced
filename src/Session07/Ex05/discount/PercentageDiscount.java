package Session07.Ex05.discount;

import Session07.Ex05.model.*;
import Session07.Ex05.repository.*;
import Session07.Ex05.discount.*;
import Session07.Ex05.payment.*;
import Session07.Ex05.notification.*;
import Session07.Ex05.service.*;

public class PercentageDiscount implements DiscountStrategy{
    private double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    public double applyDiscount(double total) {
        return total - total * percent / 100;
    }
}
