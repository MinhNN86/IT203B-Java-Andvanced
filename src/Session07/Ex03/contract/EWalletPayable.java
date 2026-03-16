package Session07.Ex03.contract;

import Session07.Ex03.contract.*;
import Session07.Ex03.payment.*;

public interface EWalletPayable extends PaymentMethod{
    void processEWallet(double amount);
}
