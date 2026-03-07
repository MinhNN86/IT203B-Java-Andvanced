package Session01.Ex06;

import java.io.IOException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        User user = new User();

        try {
            user.setName("Minh");

            user.setAge(-5);

            user.printUser();

            FileService.saveToFile();

        } catch (InvalidAgeException e) {
            Logger.logError(e.getMessage());
        } catch (IOException e) {
            Logger.logError(e.getMessage());
        }

        System.out.println("Chương trình vẫn tiếp tục chạy...");
    }
}
