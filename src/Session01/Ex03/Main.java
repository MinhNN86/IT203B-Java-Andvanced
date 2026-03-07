package Session01.Ex03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User();

        try {
            user.setAge(sc.nextInt());
        } catch (IllegalAccessException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        System.out.println("Chương trình vẫn tiếp tục chạy...");
        sc.close();
    }
}
