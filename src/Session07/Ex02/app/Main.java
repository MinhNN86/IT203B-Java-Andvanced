package Session07.Ex02.app;

import Session07.Ex02.discount.*;
import Session07.Ex02.service.*;

public class Main {
    public static void main(String[] args) {

        double total = 1000000;

        OrderCalculator calculator1 =
                new OrderCalculator(new PercentageDiscount(10));
        System.out.println("Số tiền sau giảm: " + calculator1.calculateTotal(total));

        OrderCalculator calculator2 =
                new OrderCalculator(new FixedDiscount(50000));
        System.out.println("Số tiền sau giảm: " + calculator2.calculateTotal(total));

        OrderCalculator calculator3 =
                new OrderCalculator(new NoDiscount());
        System.out.println("Số tiền sau giảm: " + calculator3.calculateTotal(total));

        OrderCalculator calculator4 =
                new OrderCalculator(new HolidayDiscount());
        System.out.println("Số tiền sau giảm: " + calculator4.calculateTotal(total));
    }
}
