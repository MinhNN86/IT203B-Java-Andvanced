package Session09.miniProject.main.java.com.traffic.util;

public class LoggerUtils {

    private static final long START_TIME_MS = System.currentTimeMillis();

    public static void log(String msg) {
        long elapsedSeconds = (System.currentTimeMillis() - START_TIME_MS) / 1000;
        System.out.println("[Time: " + elapsedSeconds + "s] " + msg);
    }
}