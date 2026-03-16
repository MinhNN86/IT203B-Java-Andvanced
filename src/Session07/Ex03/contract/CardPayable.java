package Session07.Ex03.contract;

import Session07.Ex03.contract.*;
import Session07.Ex03.payment.*;

public interface CardPayable extends PaymentMethod {
    void processCreditCard(double amount);
}
