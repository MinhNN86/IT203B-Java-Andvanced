package Session08.Ex01.device;

public class Fan implements Device {
    @Override
    public void turnOn() {
        System.out.println("Quạt: Bật.");
    }

    @Override
    public void turnOff() {
        System.out.println("Quạt: Tắt.");
    }
}
