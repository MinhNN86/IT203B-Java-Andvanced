package Session07.Ex01.service;

import Session07.Ex01.model.*;
import Session07.Ex01.service.*;
import Session07.Ex01.repository.*;

public class EmailService {
    public void sendEmail(Customer customer, String message) {
        System.out.println("Đã gửi email đến " + customer.getEmail() + ": " + message);
    }
}
