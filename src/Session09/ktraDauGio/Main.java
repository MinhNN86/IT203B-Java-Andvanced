package Session09.ktraDauGio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductDatabase db = ProductDatabase.getInstance();

        while (true){
            System.out.println("1. Add");
            System.out.println("2. View");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("1. Physical | 2. Digital");
                    int type = Integer.parseInt(sc.nextLine());
                    Product p = ProductFactory.createProduct(type, sc);
                    db.add(p);
                    break;

                case 2:
                    for (Product prod : db.getAll()) {
                        prod.displayInfo();
                    }
                    break;

                case 3:
                    System.out.print("ID: ");
                    String idUpdate = sc.nextLine();
                    System.out.print("New name: ");
                    String newName = sc.nextLine();
                    db.update(idUpdate, newName);
                    break;

                case 4:
                    System.out.print("ID: ");
                    String idDelete = sc.nextLine();
                    db.delete(idDelete);
                    break;

                case 5:
                    return;
            }
        }
    }
}
