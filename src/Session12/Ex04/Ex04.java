package Session12.Ex04;

import java.sql.*;
import java.util.List;

public class Ex04 {


    // Hằng số cầu hình
    private static final String URL = "jdbc:mysql://localhost:3306/Hospital_DB";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    // Tạo kết nối
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Nạp kết quả xét nghiệm
    public static void updateLabResult(List<LabResult> results) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();
            String sql = "INSERT INTO lab_results (patient_id, result_value) VALUES ( ? , ? )";

            pstmt = conn.prepareStatement(sql);

            for(LabResult r : results){
                pstmt.setInt(1, r.getPatientId());
                pstmt.setString(2, r.getResultValue());
                pstmt.executeUpdate();
            }

            System.out.println("Thêm kết quả xét nghiệm thành công!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        List<LabResult> results = List.of(
                new LabResult(1, "Glucose: 90 mg/dL"),
                new LabResult(2, "Cholesterol: 180 mg/dL"),
                new LabResult(3, "Hemoglobin: 13.5 g/dL"),
                new LabResult(1, "WBC: 6,000 cells/mcL"),
                new LabResult(2, "Platelets: 250,000 cells/mcL")
        );

        updateLabResult(results);
    }
}
