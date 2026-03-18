package Session08.Ex04.observer;

public class Fan implements Observer{

    @Override
    public void update(int temperature) {

        if (temperature < 20) {
            System.out.println("Quạt: Nhiệt độ thấp, tự động TẮT");
        }
        else if (temperature <= 25) {
            System.out.println("Quạt: Nhiệt độ bình thường, chạy tốc độ TRUNG BÌNH");
        }
        else {
            System.out.println("Quạt: Nhiệt độ cao, chạy tốc độ MẠNH");
        }
    }
}
