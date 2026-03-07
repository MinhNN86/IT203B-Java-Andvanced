package Session01.Ex05;

public class Main {
    public static void main(String[] args) {
        User user = new User();

        try {
            user.setAge(-10); // thử nhập tuổi âm
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Chương trình vẫn tiếp tục chạy...");
    }
}
