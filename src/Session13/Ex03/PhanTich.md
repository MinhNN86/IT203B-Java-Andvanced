## 📌 Phân tích bài toán

### 🎯 Input
- maBenhNhan (int): mã bệnh nhân
- tienVienPhi (double): số tiền cần thanh toán

---

### 🎯 Output
- Thành công: Xuất viện + thanh toán hoàn tất
- Thất bại: Throw Exception + rollback toàn bộ

---

### ⚠️ Ràng buộc nghiệp vụ

1. Không được để số dư < 0
2. Nếu UPDATE không ảnh hưởng dòng nào → coi là lỗi
3. Tất cả phải chạy trong 1 Transaction

---

## 💡 Giải pháp

- Sử dụng JDBC Transaction:
    - `setAutoCommit(false)`
    - `commit()` nếu OK
    - `rollback()` nếu lỗi

- Dùng try-catch để:
    - Bắt lỗi SQL
    - Bắt lỗi logic (thiếu tiền, row = 0)

---

## 🔄 Các bước xử lý

1. Mở connection
2. setAutoCommit(false)
3. Query lấy số dư
4. Check số dư (Bẫy 1)
5. UPDATE trừ tiền
6. UPDATE giường bệnh
7. UPDATE trạng thái bệnh nhân
8. Check row affected (Bẫy 2)
9. commit()
10. catch → rollback()
11. finally → đóng connection