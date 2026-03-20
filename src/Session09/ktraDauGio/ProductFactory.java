package Session09.ktraDauGio;

import java.util.Scanner;

public class ProductFactory {
    public static Product createProduct(int type, Scanner sc){
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = Double.parseDouble(sc.nextLine());

        if(type == 1){
            System.out.print("Wight: ");
            double weight = Double.parseDouble(sc.nextLine());
            return new PhysicalProduct(id, name, price, weight);
        } else {
            System.out.print("Size: ");
            double size = Double.parseDouble(sc.nextLine());
            return new DigitalProduct(id, name, price, size);
        }
    }
}
