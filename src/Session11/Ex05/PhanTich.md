Các kịch bản lỗi có thể xảy ra trong hệ thống:

1. Lỗi trùng khóa chính (Primary Key)

* Người dùng nhập mã bác sĩ đã tồn tại
* → Lỗi SQLIntegrityConstraintViolationException

2. Lỗi nhập dữ liệu quá dài

* Ví dụ: chuyên khoa vượt quá độ dài cột VARCHAR
* → Data too long for column

3. Lỗi để trống dữ liệu

* Không nhập tên hoặc chuyên khoa
* → Gây dữ liệu không hợp lệ

4. Lỗi định dạng dữ liệu

* Nhập sai định dạng (ví dụ nếu có ngày tháng)
* → ParseException hoặc lỗi SQL

5. Lỗi kết nối database

* Sai URL, user, password
* → SQLException

6. Lỗi SQL Injection (nếu dùng Statement)

* Người dùng nhập ký tự nguy hiểm (' OR 1=1)
* → Lộ dữ liệu

7. Lỗi không tìm thấy dữ liệu

* Bảng rỗng khi thống kê hoặc hiển thị
* → Không có kết quả

=> Cần validate dữ liệu + bắt exception để đảm bảo hệ thống chạy ổn định.
