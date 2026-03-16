package Session07.Ex05.repository;

import Session07.Ex05.model.*;
import Session07.Ex05.repository.*;
import Session07.Ex05.discount.*;
import Session07.Ex05.payment.*;
import Session07.Ex05.notification.*;
import Session07.Ex05.service.*;

import java.util.List;

public interface OrderRepository {

    void save(Order order);

    List<Order> findAll();
}
