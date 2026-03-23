package Session12.lyThuyet;

import java.sql.*;

public class DemoPrepareStatement {
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
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        // PATIENT
        try {
            conn = getConnection();
            // Viết SQL với dấu ( ? ) làm placeholder
            String sql = "SELECT * FROM patients WHERE patients_name = ?";
            // Tạo đối tuượng PreparedStatement
            pstmt = conn.prepareStatement(sql);

            // Truyền dữ liệu vào ( ? ) vị trí bắt đầu từ 1
            String searchName = "John Doe";
            pstmt.setString(1, searchName);

            // Thực thi truy vấn ( Không cần truyền lại chuỗi sql vào đây )
            rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("PATIENT");
                System.out.println(rs.getString("patients_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng theo thứ tự ngược
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // DRUGS
        try {
            conn = getConnection();

            // Khung SQL với 3 tham số cần truyền
            String sql = "INSERT INTO drugs (drug_name, quantity, price) VALUES ( ?, ?, ? ) ";

            // Chuẩn bị câu lệnh
            pstmt = conn.prepareStatement(sql);

            // Thiết lập tham số (Setter)
            pstmt.setString(1, "Test Drug");
            pstmt.setInt(2, 100);
            pstmt.setDouble(3, 9.99);

            // Thực thi cập nhật
            int rowsAffected = pstmt.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("DRUGS");
                System.out.println("Thêm thuốc thành công!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
