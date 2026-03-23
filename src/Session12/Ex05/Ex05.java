package Session12.Ex05;

import java.sql.*;
import java.util.Scanner;

public class Ex05 {
    // Hằng số cấu hình
    private static final String URL = "jdbc:mysql://localhost:3306/Hospital_DB";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    // Tạo kết nối
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        try (Connection conn = getConnection()) {
            while (true) {
                System.out.println("\n===== MENU =====");
                System.out.println("1. Danh sach benh nhan");
                System.out.println("2. Them benh nhan");
                System.out.println("3. Cap nhat benh an");
                System.out.println("4. Xuat vien & tinh phi");
                System.out.println("5. Thoat");
                System.out.print("Lua chon: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> listPatients(conn);
                    case 2 -> addPatient(conn);
                    case 3 -> updatePatient(conn);
                    case 4 -> discharge(conn);
                    case 5 -> {
                        return;
                    }
                    default -> System.out.println("Lua chon khong hop le!");
                }
            }
        }
    }

    static void listPatients(Connection conn) throws Exception {
        String sql = "SELECT * FROM patients";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getInt("patient_id") + " - " +
                        rs.getString("patients_name") + " - " +
                        rs.getDate("date_of_birth") + " - " +
                        rs.getString("department"));
            }
        }
    }

    static void addPatient(Connection conn) throws Exception {
        String sql = "INSERT INTO patients(patients_name, temperature, heart_rate, department, diagnosis, days_admitted, date_of_birth) " +
                "VALUES (?, ?, ?, ?, ?, ? , ? )";

        System.out.print("Nhap ten benh nhan: ");
        String name = sc.nextLine();
        System.out.print("Nhap ngay sinh (yyyy-MM-dd): ");
        String dob = sc.nextLine();
        System.out.print("Nhap khoa: ");
        String dept = sc.nextLine();
        System.out.print("Nhap chan doan: ");
        String diag = sc.nextLine();
        System.out.print("Nhap so ngay nam vien: ");
        int days = sc.nextInt();
        sc.nextLine();

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setDouble(2, 0);
            ps.setInt(3, 0);
            ps.setString(4, dept);
            ps.setString(5, diag);
            ps.setInt(6, days);
            ps.setDate(7, Date.valueOf(dob));

            ps.executeUpdate();
        }
        System.out.println("Them benh nhan thanh cong!");
    }

    static void updatePatient(Connection conn) throws Exception {
        String sql = "UPDATE patients SET diagnosis=? WHERE patient_id=?";

        System.out.print("Nhap ID: ");
        int id = sc.nextInt(); sc.nextLine();

        System.out.print("Benh moi: ");
        String diagnosis = sc.nextLine();

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, diagnosis);
            ps.setInt(2, id);

            int updated = ps.executeUpdate();
            if (updated > 0) {
                System.out.println("Cap nhat thanh cong!");
            } else {
                System.out.println("Khong tim thay benh nhan voi ID: " + id);
            }
        }
    }

    static void discharge(Connection conn) throws Exception {
        String sql = "{call CALCULATE_DISCHARGE_FEE(?, ?)}";

        System.out.print("Nhap ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, id);
            cs.registerOutParameter(2, Types.DECIMAL);

            cs.execute();

            double fee = cs.getDouble(2);
            System.out.println("Vien phi: " + fee);
        }
    }
}
