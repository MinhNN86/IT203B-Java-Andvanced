package Session07.Ex02.discount;

import Session07.Ex02.discount.*;
import Session07.Ex02.service.*;

// thêm loại giảm mới
public class HolidayDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount * 0.85; // giảm 15%
    }
}
