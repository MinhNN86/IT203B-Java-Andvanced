package Session12.Ex03;

import java.sql.*;

public class Ex03 {
    // Hằng số cầu hình
    private static final String URL = "jdbc:mysql://localhost:3306/Hospital_DB";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    // Tạo kết nối
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Tra cứu chi phí phẫu thuật
    public static void getSurgeryCost(int surgeryId) {
        Connection conn = null;
        CallableStatement cstmt = null;

        try{
            conn = getConnection();

            String sql = "{CALL GET_SURGERY_FEE( ? , ? )}";

            cstmt = conn.prepareCall(sql);

            cstmt.setInt(1, surgeryId);
            cstmt.registerOutParameter(2, Types.DECIMAL);
            cstmt.execute();
            double totalCost = cstmt.getDouble(2);

            System.out.println("Chi phí phấu thuật: " + totalCost);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        getSurgeryCost(1);
    }
}
