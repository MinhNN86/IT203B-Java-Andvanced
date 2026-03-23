package Session12.Ex02;

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

    // Cập nhật chỉ số sinh tồn bệnh nhân
    public static void updateVitalSigns(int patientId, double temperature, int heartRate) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();

            String sql = "UPDATE patients SET temperature = ?, heart_rate = ? WHERE patient_id = ?";

            pstmt = conn.prepareStatement(sql);

            pstmt.setDouble(1, temperature);
            pstmt.setInt(2, heartRate);
            pstmt.setInt(3, patientId);

            int rows = pstmt.executeUpdate();

            if(rows > 0){
                System.out.println("Cập nhật chỉ số sinh tồn thành công cho bệnh nhân ID: " + patientId);
            } else {
                System.out.println("Không tìm thấy bệnh nhân với ID: " + patientId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        updateVitalSigns(1, 37.5, 80);
        updateVitalSigns(10, 38.0, 90);
    }
}
