package Session07.Ex04.model;

import Session07.Ex04.model.*;
import Session07.Ex04.repository.*;
import Session07.Ex04.notification.*;
import Session07.Ex04.service.*;

public class Order {
    private String id;

    public Order(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
