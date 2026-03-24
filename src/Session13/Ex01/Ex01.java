package Session13.Ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex01 {
    // Hằng số cấu hình
    private static final String URL = "jdbc:mysql://localhost:3306/Hospital_DB";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    // Tạo kết nối
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Cấp phát thuốc
    public static void dispenseMedicine(int patientId, int drugId, int quantity) {
        Connection conn = null;

        try{
            conn = getConnection();
            conn.setAutoCommit(false);

            String sql1 = "UPDATE drugs SET quantity = quantity - ? WHERE drug_id = ? AND quantity >= ?";
            PreparedStatement updateInventory = conn.prepareStatement(sql1);
            updateInventory.setInt(1, quantity);
            updateInventory.setInt(2, drugId);
            updateInventory.setInt(3, quantity);

            int rowsAffected = updateInventory.executeUpdate();
            if(rowsAffected > 0){
                String sql2 = "INSERT INTO Prescription_History(drug_id, patient_id) VALUES ( ?, ? )";
                PreparedStatement insertPrescription = conn.prepareStatement(sql2);
                insertPrescription.setInt(1, drugId);
                insertPrescription.setInt(2, patientId);

                int prescriptionResult = insertPrescription.executeUpdate();
                if(prescriptionResult > 0){
                    conn.commit();
                    System.out.println("Cấp phát thuốc thành công!");
                } else {
                    conn.rollback();
                    System.out.println("Lỗi khi ghi đơn thuốc. Giao dịch đã được rollback.");
                }
            } else {
                conn.rollback();
                System.out.println("Không đủ số lượng thuốc trong kho. Giao dịch đã được rollback.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        dispenseMedicine(1, 2, 5);
    }
}
