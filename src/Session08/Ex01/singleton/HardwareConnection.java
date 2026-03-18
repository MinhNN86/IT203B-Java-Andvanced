package Session08.Ex01.singleton;

public class HardwareConnection {
    private static HardwareConnection instance;

    private HardwareConnection(){}

    public static HardwareConnection getInstance(){
        if(instance == null){
            instance = new HardwareConnection();
            System.out.println("HardwareConnection: Đã kết nối phần cứng.");
        }
        return instance;
    }

    public void connect(){
        System.out.println("Kết nối đang được sử dụng.");
    }

    public void disconnect(){
        System.out.println("HardwareConnection: Ngắt kết nối.");
    }
}
