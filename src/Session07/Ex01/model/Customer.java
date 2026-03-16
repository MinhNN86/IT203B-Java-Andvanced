package Session07.Ex01.model;

import Session07.Ex01.model.*;
import Session07.Ex01.service.*;
import Session07.Ex01.repository.*;

public class Customer {
    private String name;
    private String email;
    private String address;

    public Customer(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
