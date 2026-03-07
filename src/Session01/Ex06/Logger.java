package Session01.Ex06;

import java.time.LocalDate;

public class Logger {
    public static void logError(String message) {
        System.out.println("[ERROR] " + LocalDate.now() + " - " + message);
    }
}
