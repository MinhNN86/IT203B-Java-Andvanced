package Session13.Ex05;

import java.sql.*;

public class BenhNhanController {

    // Hằng số cấu hình
    private static final String URL = "jdbc:mysql://localhost:3306/Hospital_DB_v3";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    // Tạo kết nối
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void tiepNhan(String name, int age, int bedId, double amount) {
        Connection conn = null;

        try {
            conn = getConnection();
            conn.setAutoCommit(false);

            // 1. Insert bệnh nhân
            String sql1 = "INSERT INTO Patients(name, age, bed_id, status) VALUES (?, ?, ?, 'ADMITTED')";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setString(1, name);
            ps1.setInt(2, age);
            ps1.setInt(3, bedId);
            ps1.executeUpdate();

            ResultSet rs = ps1.getGeneratedKeys();
            rs.next();
            int patientId = rs.getInt(1);

            // 2. Update giường (bẫy: giường phải trống)
            String sql2 = "UPDATE Beds SET status = 'OCCUPIED' WHERE bed_id = ? AND status = 'EMPTY'";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, bedId);
            int row = ps2.executeUpdate();

            if (row == 0) {
                throw new RuntimeException("Giường đã có người!");
            }

            // 3. Insert tài chính
            String sql3 = "INSERT INTO Finance(patient_id, amount, created_at) VALUES (?, ?, NOW())";
            PreparedStatement ps3 = conn.prepareStatement(sql3);
            ps3.setInt(1, patientId);
            ps3.setDouble(2, amount);
            ps3.executeUpdate();

            conn.commit();
            System.out.println("✅ Tiếp nhận thành công!");

        } catch (Exception e) {

            try {
                if (conn != null) conn.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            System.out.println("❌ Lỗi: " + e.getMessage());

        } finally {
            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
