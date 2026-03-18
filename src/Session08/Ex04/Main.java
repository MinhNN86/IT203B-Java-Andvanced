package Session08.Ex04;

import java.util.Scanner;
import Session08.Ex04.subject.*;
import Session08.Ex04.observer.*;

public class Main {

    public static void main(String[] args) {

        TemperatureSensor sensor = new TemperatureSensor();

        Fan fan = new Fan();
        Humidifier humidifier = new Humidifier();

        System.out.println("Quạt: Đã đăng ký nhận thông báo");
        System.out.println("Máy tạo ẩm: Đã đăng ký");

        sensor.attach(fan);
        sensor.attach(humidifier);

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("\nNhập nhiệt độ mới (-1 để thoát): ");
            int temp = scanner.nextInt();

            if (temp == -1) {
                break;
            }

            sensor.setTemperature(temp);
        }
    }
}
