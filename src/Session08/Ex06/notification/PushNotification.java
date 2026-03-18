package Session08.Ex06.notification;

public class PushNotification implements NotificationService {

    @Override
    public void notifyUser(String message) {
        System.out.println("Gửi push notification: " + message);
    }
}
