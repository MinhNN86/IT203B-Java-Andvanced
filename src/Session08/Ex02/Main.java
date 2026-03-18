package Session08.Ex02;
import java.util.Scanner;

import Session08.Ex02.facade.SmartHomeFacade;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SmartHomeFacade facade = new SmartHomeFacade();

        while (true) {

            System.out.println("\n===== SMART HOME =====");
            System.out.println("1. Xem nhiệt độ");
            System.out.println("2. Chế độ rời nhà");
            System.out.println("3. Chế độ ngủ");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    facade.getCurrentTemperature();
                    break;

                case 2:
                    facade.leaveHome();
                    break;

                case 3:
                    facade.sleepMode();
                    break;

                case 4:
                    System.out.println("Thoát chương trình.");
                    return;
            }
        }
    }
}
