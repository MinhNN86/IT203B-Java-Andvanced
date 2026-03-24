## 📌 Phân tích bài toán

### 🎯 Input (chức năng tiếp nhận)
- tenBenhNhan (String)
- tuoi (int)
- maGiuong (int)
- soTienTamUng (double)

---

### 🎯 Output
- Thành công: "Tiếp nhận bệnh nhân thành công"
- Thất bại: Thông báo lỗi + rollback

---

### ⚠️ Ràng buộc
- 3 thao tác phải chạy trong 1 transaction:
    1. Insert bệnh nhân
    2. Update giường → OCCUPIED
    3. Insert tài chính

👉 All or Nothing

---

## ⚠️ Edge Cases (bẫy lỗi)

1. Nhập sai dữ liệu:
    - "Năm trăm" thay vì số → NumberFormatException

2. Giường đã có người:
    - Update không thành công → dữ liệu sai

3. Mất mạng giữa chừng:
    - Insert bệnh nhân OK nhưng update giường fail

👉 Phải rollback

---

## 💡 Giải pháp

- Dùng JDBC Transaction:
    - setAutoCommit(false)
    - commit() / rollback()

- Validate input trước khi xử lý

- Tách lớp:
    - View (Console)
    - Controller (logic)
    - DB Helper