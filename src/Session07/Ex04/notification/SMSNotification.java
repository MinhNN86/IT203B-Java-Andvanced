package Session07.Ex04.notification;

import Session07.Ex04.model.*;
import Session07.Ex04.repository.*;
import Session07.Ex04.notification.*;
import Session07.Ex04.service.*;

public class SMSNotification implements NotificationService {

    @Override
    public void send(String message, String recipient) {
        System.out.println("Gửi SMS: " + message);
    }
}
