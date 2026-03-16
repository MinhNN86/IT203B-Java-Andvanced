package Session07.Ex06.notification;

import Session07.Ex06.factory.*;
import Session07.Ex06.discount.*;
import Session07.Ex06.payment.*;
import Session07.Ex06.notification.*;
import Session07.Ex06.service.*;

public class EmailNotification implements NotificationService {

    public void send(String message) {
        System.out.println("Gửi email xác nhận");
    }
}
