package Session07.Ex05.discount;

import Session07.Ex05.model.*;
import Session07.Ex05.repository.*;
import Session07.Ex05.discount.*;
import Session07.Ex05.payment.*;
import Session07.Ex05.notification.*;
import Session07.Ex05.service.*;

public class HolidayDiscount implements DiscountStrategy {

    public double applyDiscount(double total) {
        return total * 0.85;
    }
}
