package Session13.lyThuyet.dao.impl;

import Session13.lyThuyet.dao.AccountDAO;
import Session13.lyThuyet.db.DBUtility;
import Session13.lyThuyet.entity.Account;

import java.sql.*;

public class AccountDAOImpl implements AccountDAO {
    @Override
    public boolean transferMoney(Account fromAccount, Account toAccount, double amount){
        boolean result = false;

        Connection con;
        PreparedStatement pstmt = null;

        con = DBUtility.connectMySql();

        try{
            con.setAutoCommit(false);
            String sql = "UPDATE accounts SET balance = balance - ? WHERE account_number = ? AND balance >= ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setDouble(1, amount);
            pstmt.setString(2, fromAccount.getAccountNumber());
            pstmt.setDouble(3, amount);

            int i = pstmt.executeUpdate();
            int j = 0;
            if(i > 0){
                String sql2 = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";
                pstmt = con.prepareStatement(sql2);
                pstmt.setDouble(1, amount);
                pstmt.setString(2, toAccount.getAccountNumber());

                j = pstmt.executeUpdate();
                if(j > 0){
                    result = true;
                }
            }

            if(i > 0 && j > 0){
                con.commit();
            } else {
                con.rollback();
            }

        } catch (Exception e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
        } finally  {
            DBUtility.closeAll(con, pstmt, null);
        }

        return result;
    }
}
