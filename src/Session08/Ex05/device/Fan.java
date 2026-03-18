package Session08.Ex05.device;

import Session08.Ex04.observer.Observer;

public class Fan implements Observer {

    private String speed = "OFF";

    public void setLow() {
        speed = "LOW";
        System.out.println("Quạt: Chạy tốc độ thấp");
    }

    public void setHigh() {
        speed = "HIGH";
        System.out.println("Quạt: Nhiệt độ cao, chạy tốc độ mạnh");
    }

    @Override
    public void update(int temperature) {

        if (temperature > 30) {
            setHigh();
        }
    }

    public String getStatus() {
        return speed;
    }
}
