package Session07.Ex03.contract;

import Session07.Ex03.contract.*;
import Session07.Ex03.payment.*;

public interface CODPayable extends PaymentMethod{
    void processCOD(double amount);
}
