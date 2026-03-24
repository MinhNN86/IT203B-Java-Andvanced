package Session13.Ex04;

import java.sql.*;
import java.util.*;

public class Ex04 {
    // Hằng số cấu hình
    private static final String URL = "jdbc:mysql://localhost:3306/Hospital_DB_v2";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    // Tạo kết nối
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public List<BenhNhanDTO> getDashboard() {
        List<BenhNhanDTO> result = new ArrayList<>();
        Map<Integer, BenhNhanDTO> map = new HashMap<>();

        try (Connection conn = getConnection()) {

            String sql = "SELECT bn.patient_id, bn.name AS patient_name, " +
                    "dv.maDichVu, dv.tenDichVu " +
                    "FROM Patients bn " +
                    "LEFT JOIN DichVuSuDung dv " +
                    "ON bn.patient_id = dv.maBenhNhan";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int maBN = rs.getInt("patient_id");

                BenhNhanDTO bn = map.get(maBN);
                if (bn == null) {
                    bn = new BenhNhanDTO();
                    bn.setMaBenhNhan(maBN);
                    bn.setTenBenhNhan(rs.getString("patient_name"));
                    bn.setDsDichVu(new ArrayList<>());
                    map.put(maBN, bn);
                }

                int maDV = rs.getInt("maDichVu");

                if (!rs.wasNull()) {
                    DichVu dv = new DichVu();
                    dv.setMaDichVu(maDV);
                    dv.setTenDichVu(rs.getString("tenDichVu"));

                    bn.getDsDichVu().add(dv);
                }
            }

            result.addAll(map.values());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {
        Ex04 ex = new Ex04();
        List<BenhNhanDTO> dashboard = ex.getDashboard();
        for (BenhNhanDTO bn : dashboard) {
            System.out.println(bn);
        }
    }
}
