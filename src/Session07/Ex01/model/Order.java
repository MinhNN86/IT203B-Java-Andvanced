package Session07.Ex01.model;

import Session07.Ex01.model.*;
import Session07.Ex01.service.*;
import Session07.Ex01.repository.*;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private String orderId;
    private Customer customer;
    private Map<Product, Integer> products;
    private double total;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }
}
