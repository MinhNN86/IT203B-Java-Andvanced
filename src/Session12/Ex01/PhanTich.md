**Tại sao PreparedStatement là “tấm khiên” chống SQL Injection?**

PreparedStatement giúp ngăn chặn SQL Injection nhờ cơ chế **tham số hóa (parameterized)** và **biên dịch trước (pre-compiled)**.

* **Tách biệt lệnh và dữ liệu:**
  Câu lệnh SQL được định nghĩa trước với dấu `?`, còn dữ liệu người dùng được truyền vào sau bằng `setXXX()`.
  👉 Dữ liệu luôn được coi là giá trị thuần, không thể trở thành một phần của câu lệnh SQL.

* **Cơ chế Pre-compiled:**
  Câu lệnh SQL được Database **biên dịch trước** và cố định cấu trúc.
  👉 Người dùng không thể chèn thêm logic SQL như `' OR '1'='1` để thay đổi câu lệnh.

**Kết luận:**
PreparedStatement bảo vệ ứng dụng vì **không cho phép dữ liệu đầu vào làm thay đổi cấu trúc SQL**, từ đó chống SQL Injection hiệu quả.
