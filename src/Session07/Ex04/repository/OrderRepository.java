package Session07.Ex04.repository;

import Session07.Ex04.model.*;
import Session07.Ex04.repository.*;
import Session07.Ex04.notification.*;
import Session07.Ex04.service.*;

import java.util.List;

public interface OrderRepository {

    void save(Order order);

    List<Order> findAll();
}
