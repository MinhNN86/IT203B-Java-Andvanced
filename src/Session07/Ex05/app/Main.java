package Session07.Ex05.app;

import Session07.Ex05.model.*;
import Session07.Ex05.repository.*;
import Session07.Ex05.discount.*;
import Session07.Ex05.payment.*;
import Session07.Ex05.notification.*;
import Session07.Ex05.service.*;

public class Main {

    public static void main(String[] args) {

        Product laptop = new Product("SP01","Laptop",15000000);

        Customer customer =
                new Customer("Nguyễn Văn A","a@example.com","0123456789");

        Order order = new Order("ORD001",customer);

        order.addItem(new OrderItem(laptop,1));

        DiscountStrategy discount =
                new PercentageDiscount(10);

        PaymentMethod payment =
                new CreditCardPayment();

        OrderRepository repository =
                new FileOrderRepository();

        NotificationService notification =
                new EmailNotification();

        OrderService service =
                new OrderService(repository,notification);

        InvoiceGenerator invoice =
                new InvoiceGenerator();

        invoice.printInvoice(order,discount);

        payment.pay(discount.applyDiscount(order.getTotalAmount()));

        service.createOrder(order);
    }
}
