package Session07.Ex01.service;

import Session07.Ex01.model.*;
import Session07.Ex01.service.*;
import Session07.Ex01.repository.*;

import java.util.Map;

public class OrderCalculator {
    public double calculateTotal(Order order) {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : order.getProducts().entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        order.setTotal(total);
        return total;
    }
}
