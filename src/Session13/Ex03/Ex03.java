package Session13.Ex03;

import java.sql.*;

public class Ex03 {
    // Hằng số cấu hình
    private static final String URL = "jdbc:mysql://localhost:3306/Hospital_DB_v2";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    // Tạo kết nối
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void xuatVienVaThanhToan(int maBenhNhan, double tienVienPhi) {
        Connection conn = null;
        PreparedStatement psCheck = null;
        PreparedStatement psUpdateWallet = null;
        PreparedStatement psUpdateBed = null;
        PreparedStatement psUpdatePatient = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            conn.setAutoCommit(false);

            // 1. Kiểm tra số dư
            String checkSql = "SELECT balance FROM Patient_Wallet WHERE patient_id = ?";
            psCheck = conn.prepareStatement(checkSql);
            psCheck.setInt(1, maBenhNhan);
            rs = psCheck.executeQuery();

            if(!rs.next()){
                throw new RuntimeException("Bệnh nhân không tồn tại");
            }

            double balance = rs.getDouble("balance");

            // Kiểm tra đủ tiền
            if (balance < tienVienPhi) {
                throw new RuntimeException("Không đủ tiền để thanh toán viện phí");
            }

            // 2. Trừ tiền
            String sqlUpdateWallet = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
            psUpdateWallet = conn.prepareStatement(sqlUpdateWallet);
            psUpdateWallet.setDouble(1, tienVienPhi);
            psUpdateWallet.setInt(2, maBenhNhan);
            int row1 = psUpdateWallet.executeUpdate();

            // 3. Cập nhật tình trạng giường
            String sqlUpdateBed = "UPDATE Beds SET status = 'Không sủ dụng' WHERE patient_id = ?";
            psUpdateBed = conn.prepareStatement(sqlUpdateBed);
            psUpdateBed.setInt(1, maBenhNhan);
            int row2 = psUpdateBed.executeUpdate();

            // 4. Cập nhật tình trạng bệnh nhân
            String sql3 = "UPDATE Patients SET status = 'Đã xuất viện' WHERE patient_id = ?";
            psUpdatePatient = conn.prepareStatement(sql3);
            psUpdatePatient.setInt(1, maBenhNhan);
            int row3 = psUpdatePatient.executeUpdate();

            if (row1 == 0 || row2 == 0 || row3 == 0) {
                throw new RuntimeException("Dữ liệu không hợp lệ");
            }

            conn.commit();
            System.out.println("Xuất viện thành công!");

        } catch (Exception e) {
            try {
                if(conn != null){
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            System.out.println("Lỗi: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (psCheck != null) psCheck.close();
                if (psUpdateWallet != null) psUpdateWallet.close();
                if (psUpdateBed != null) psUpdateBed.close();
                if (psUpdatePatient != null) psUpdatePatient.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Ex03().xuatVienVaThanhToan(1001, 500);
        new Ex03().xuatVienVaThanhToan(1, 500);
    }
}
