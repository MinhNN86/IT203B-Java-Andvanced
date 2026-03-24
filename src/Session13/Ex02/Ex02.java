package Session13.Ex02;

import java.sql.*;

public class Ex02 {
    // Hằng số cấu hình
    private static final String URL = "jdbc:mysql://localhost:3306/Hospital_DB";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    // Tạo kết nối
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement deductMoney = null;
        PreparedStatement updateInvoice = null;

        try {
            conn = getConnection();
            conn.setAutoCommit(false);

            // 1. Trừ tiền từ tài khoản bệnh nhân
            String sql1 = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ? AND balance >= ?";
            deductMoney = conn.prepareStatement(sql1);
            deductMoney.setDouble(1, 100);
            deductMoney.setInt(2, 1001);
            deductMoney.setDouble(3, 100);
            deductMoney.executeUpdate();

            // Cập nhật hóa đơn
            String sql2 = "UPDATE Invoices SET status = 'PAID' WHERE invoice_id = ?";
            updateInvoice = conn.prepareStatement(sql2);
            updateInvoice.setInt(1, 2001);
            updateInvoice.executeUpdate();

            conn.commit();
            System.out.println("Thanh toán thành công!");


        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }

            e.printStackTrace();
        } finally {
            try {
                if (deductMoney != null) deductMoney.close();
                if (updateInvoice != null) updateInvoice.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
