package Session08.Ex06.notification;

public class PrintReceipt implements NotificationService {

    @Override
    public void notifyUser(String message) {
        System.out.println("In hóa đơn: " + message);
    }
}
