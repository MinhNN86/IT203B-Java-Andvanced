Lệnh if không đủ để xử lý yêu cầu "in danh sách" vì:

* if(rs.next()) chỉ kiểm tra và di chuyển con trỏ xuống đúng 1 dòng đầu tiên.
* Sau khi thực hiện xong, chương trình không tiếp tục đọc các dòng tiếp theo nên chỉ in được 1 bản ghi.

Cơ chế con trỏ của ResultSet:

* Ban đầu con trỏ nằm trước dòng đầu tiên.
* Mỗi lần gọi next() → con trỏ di chuyển xuống 1 dòng.
* Nếu còn dữ liệu → trả về true.
* Nếu hết dữ liệu → trả về false.

Vì vậy, để duyệt toàn bộ dữ liệu, cần dùng vòng lặp (while) thay vì if.
