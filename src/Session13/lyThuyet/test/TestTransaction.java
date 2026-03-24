package Session13.lyThuyet.test;

import Session13.lyThuyet.dao.impl.AccountDAOImpl;
import Session13.lyThuyet.entity.Account;

public class TestTransaction {
    public static void main(String[] args) {
        Account acc1 = new Account();
        Account acc2 = new Account();

        acc1.setAccountNumber("ACC001");
        acc2.setAccountNumber("ACC002");

        boolean bl = new AccountDAOImpl().transferMoney(acc1, acc2, 500);
        if(bl){
            System.out.println("Chuyển tiền thành công");
        } else {
            System.out.println("Chuyển tiền thất bại");
        }
    }
}
