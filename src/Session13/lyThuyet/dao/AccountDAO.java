package Session13.lyThuyet.dao;

import Session13.lyThuyet.entity.Account;

import java.sql.SQLException;

public interface AccountDAO {
    boolean transferMoney(Account fromAccount, Account toAccount, double amount);
}
