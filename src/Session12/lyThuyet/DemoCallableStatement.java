package Session12.lyThuyet;

import java.sql.*;

public class DemoCallableStatement {
    // Hằng số cầu hình
    private static final String URL = "jdbc:mysql://localhost:3306/Hospital_DB";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    // Tạo kết nối
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        Connection conn = null;
        CallableStatement cstmt = null;

        try{
            conn = getConnection();

            // Cú pháp gọi Stored Procedure
            String sql = "{CALL get_drug_statistics( ? , ? )}";

            // Tạo đoối tượng CallableStatement
            cstmt = conn.prepareCall(sql);

            // Truyền tham số đầu vào
            cstmt.setInt(1, 1);

            // Đămg ký tham số đầu ra
            cstmt.registerOutParameter(2, Types.INTEGER);

            // Thực thi
            cstmt.execute();

            // Lấy ra keết quả từ tham số OUT
            int totalSold = cstmt.getInt(2);

            System.out.println("Tổng số lượng thuốc đã bán: " + totalSold);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
