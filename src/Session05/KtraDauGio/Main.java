package Session05.KtraDauGio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidProductException {
        Scanner sc = new Scanner(System.in);
        ProductManager manager = new ProductManager();

        while (true) {
            System.out.println("========= PRODUCT MANAGEMENT SYSTEM =========");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị sản phẩm");
            System.out.println("3. Cập nhật số lượng theo ID");
            System.out.println("4. Xóa sản phẩm đã hết hàng");
            System.out.println("5. Thoát");
            System.out.print("Lựa chon của bạn: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Category: ");
                    String category = sc.nextLine();

                    Product p = new Product(id, name, price, quantity, category);

                    manager.addProduct(p);
                    break;

                case 2:
                    manager.displayProducts();
                    break;
                case 3:
                    System.out.print("Enter product ID: ");
                    int updateId = sc.nextInt();

                    System.out.print("New quantity: ");
                    int newQuantity = sc.nextInt();

                    manager.updateProduct(updateId, newQuantity);
                    break;
                case 4:
                    manager.deleteProduct();
                    break;
                case 5:
                    System.out.println("Đang thoát...");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}