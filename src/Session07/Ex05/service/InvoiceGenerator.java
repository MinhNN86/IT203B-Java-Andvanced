package Session07.Ex05.service;

import Session07.Ex05.model.*;
import Session07.Ex05.repository.*;
import Session07.Ex05.discount.*;
import Session07.Ex05.payment.*;
import Session07.Ex05.notification.*;
import Session07.Ex05.service.*;

public class InvoiceGenerator {

    public void printInvoice(Order order,
                             DiscountStrategy discount) {

        double total = order.getTotalAmount();
        double finalAmount = discount.applyDiscount(total);

        System.out.println("=== HÓA ĐƠN ===");

        System.out.println("Khách: " + order.getCustomer().getName());

        for (OrderItem item : order.getItems()) {

            System.out.println(
                    item.getProduct().getName()
                            + " - SL: "
                            + item.getQuantity()
                            + " - Thành tiền: "
                            + item.getTotal()
            );
        }

        System.out.println("Tổng tiền: " + total);
        System.out.println("Sau giảm giá: " + finalAmount);
    }
}
