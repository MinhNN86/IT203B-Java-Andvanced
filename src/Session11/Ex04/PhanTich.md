Khi sử dụng nối chuỗi để tạo câu lệnh SQL, dữ liệu người dùng nhập vào sẽ được gắn trực tiếp vào câu lệnh.

Ví dụ:
Nếu người dùng nhập: ' OR '1'='1

Câu lệnh SQL sẽ trở thành:
SELECT * FROM patients WHERE name = '' OR '1'='1';

Phân tích:

* '1'='1' luôn đúng (true)
* Do có toán tử OR, toàn bộ điều kiện WHERE luôn đúng

Kết quả:

* Hệ thống sẽ trả về toàn bộ dữ liệu trong bảng patients thay vì chỉ một bệnh nhân
* Đây chính là lỗ hổng SQL Injection gây rò rỉ dữ liệu

Ngoài ra, ký tự -- có thể dùng để comment phần còn lại của câu lệnh, giúp hacker kiểm soát truy vấn hoàn toàn.
