package Session13.Ex05;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static BenhNhanController controller = new BenhNhanController();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Tiếp nhận bệnh nhân");
            System.out.println("0. Thoát");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Tên: ");
                        String name = sc.nextLine();

                        System.out.print("Tuổi: ");
                        int age = Integer.parseInt(sc.nextLine());

                        System.out.print("Mã giường: ");
                        int bed = Integer.parseInt(sc.nextLine());

                        System.out.print("Tiền tạm ứng: ");
                        double money = Double.parseDouble(sc.nextLine());

                        controller.tiepNhan(name, age, bed, money);

                    } catch (Exception e) {
                        System.out.println("❌ Nhập sai dữ liệu!");
                    }
                    break;

                case 0:
                    System.exit(0);
            }
        }
    }
}
