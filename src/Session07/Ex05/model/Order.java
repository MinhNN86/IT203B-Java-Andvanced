package Session07.Ex05.model;

import Session07.Ex05.model.*;
import Session07.Ex05.repository.*;
import Session07.Ex05.discount.*;
import Session07.Ex05.payment.*;
import Session07.Ex05.notification.*;
import Session07.Ex05.service.*;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String id;
    private Customer customer;
    private List<OrderItem> items = new ArrayList<>();

    public Order(String id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double getTotalAmount() {
        return items.stream()
                .mapToDouble(OrderItem::getTotal)
                .sum();
    }

    public String getId() { return id; }
    public Customer getCustomer() { return customer; }
    public List<OrderItem> getItems() { return items; }
}
