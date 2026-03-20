Giá trị trả về của phương thức executeUpdate() là một số nguyên (int), đại diện cho số lượng dòng dữ liệu bị tác động bởi câu lệnh SQL (INSERT, UPDATE, DELETE).

* Nếu giá trị > 0: Có ít nhất một dòng đã được cập nhật → thao tác thành công.
* Nếu giá trị = 0: Không có dòng nào bị tác động → có thể do điều kiện WHERE không khớp (ví dụ: mã giường không tồn tại).

Trong bài toán này, nếu executeUpdate() trả về 0, ta có thể kết luận rằng mã giường không tồn tại và cần thông báo cho y tá để tránh hiểu nhầm là cập nhật thành công.
