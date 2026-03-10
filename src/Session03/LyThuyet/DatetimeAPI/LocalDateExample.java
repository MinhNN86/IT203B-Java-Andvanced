package Session03.LyThuyet.DatetimeAPI;

import java.time.LocalDate;
import java.time.Month;

public class LocalDateExample {
    public static void main(String[] args) {
        // Current Date
        LocalDate today = LocalDate.now();
        System.out.println("Current Date: " + today);

        // Creating LocalDate by providing input arguments
        LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
        System.out.println("Specific Date = " + firstDay_2014);

        // Current Date in "Asia/Ho_Chi_Minh" timezone
        LocalDate todayInHCM = LocalDate.now(java.time.ZoneId.of("Asia/Ho_Chi_Minh"));
        System.out.println("Current Date in Asia/Ho_Chi_Minh timezone: " + todayInHCM);

        // Getting date from the base date
        LocalDate dateFromBase = LocalDate.ofEpochDay(365);
        System.out.println("365th day from base date = " + dateFromBase);

        // Obtains an instance of LocalDate from a year and day-of-year
        LocalDate hundredDayOf2014 = LocalDate.ofYearDay(2014, 100);
        System.out.println("100th day of 2014 = " + hundredDayOf2014);
    }
}
