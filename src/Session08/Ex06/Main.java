package Session08.Ex06;

import java.util.Scanner;
import Session08.Ex06.factory.*;
import Session08.Ex06.service.OrderService;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Chọn kênh bán hàng:");
        System.out.println("1. Website");
        System.out.println("2. Mobile App");
        System.out.println("3. POS");
        System.out.print("Lựa chọn của bạn: ");

        int choice = scanner.nextInt();

        SalesChannelFactory factory = null;

        switch (choice) {
            case 1:
                System.out.println("Bạn đã chọn kênh Website");
                factory = new WebsiteFactory();
                break;

            case 2:
                System.out.println("Bạn đã chọn kênh Mobile App");
                factory = new MobileAppFactory();
                break;

            case 3:
                System.out.println("Bạn đã chọn kênh POS");
                factory = new POSFactory();
                break;
        }

        System.out.println("Nhập giá sản phẩm:");
        double price = scanner.nextDouble();

        System.out.println("Nhập số lượng:");
        int quantity = scanner.nextInt();

        OrderService orderService = new OrderService(factory);

        orderService.processOrder(price, quantity);
    }
}
