package Session07.Ex06.app;

import Session07.Ex06.factory.*;
import Session07.Ex06.discount.*;
import Session07.Ex06.payment.*;
import Session07.Ex06.notification.*;
import Session07.Ex06.service.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Chọn kênh bán:");
        System.out.println("1. Website");
        System.out.println("2. Mobile App");
        System.out.println("3. Store POS");

        int choice = sc.nextInt();

        SalesChannelFactory factory = null;

        switch (choice) {
            case 1:
                factory = new WebsiteFactory();
                System.out.println("Bạn đã chọn kênh Website");
                break;

            case 2:
                factory = new MobileFactory();
                System.out.println("Bạn đã chọn kênh Mobile App");
                break;

            case 3:
                factory = new POSFactory();
                System.out.println("Bạn đã chọn kênh POS");
                break;
        }

        OrderService orderService = new OrderService(factory);

        orderService.createOrder(15000000);
    }
}
