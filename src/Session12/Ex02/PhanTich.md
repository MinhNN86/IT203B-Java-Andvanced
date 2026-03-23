**Tại sao setDouble(), setInt() giúp không cần lo dấu chấm / dấu phẩy?**

Các phương thức như `setDouble()` và `setInt()` của PreparedStatement giúp tránh lỗi định dạng vì:

* **Không xử lý dưới dạng chuỗi:**
  Dữ liệu không bị nối vào SQL bằng text → không phụ thuộc dấu `.` hay `,`.

* **JDBC tự động định dạng:**
  JDBC sẽ chuyển đổi giá trị Java (double, int) sang định dạng chuẩn mà Database hiểu được.

* **Không phụ thuộc Locale hệ điều hành:**
  Dù máy dùng dấu `37.5` hay `37,5`, khi dùng `setDouble()` thì JDBC vẫn truyền đúng giá trị số.

👉 **Kết luận:**
PreparedStatement giúp tránh lỗi định dạng vì **xử lý dữ liệu theo kiểu (type-safe)** thay vì chuỗi.
