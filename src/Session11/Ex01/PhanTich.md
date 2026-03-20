Việc khởi tạo kết nối liên tục mà không đóng (close) hoặc không quản lý tập trung sẽ gây nguy hiểm cho hệ thống vì:

* Mỗi kết nối đến Database đều tiêu tốn tài nguyên (bộ nhớ, socket, thread).
* Nếu không đóng kết nối, các kết nối sẽ bị “rò rỉ” (connection leak) và tích tụ theo thời gian.
* Sau một thời gian, Database sẽ đạt giới hạn số lượng kết nối cho phép → không thể tạo thêm kết nối mới.
* Điều này dẫn đến lỗi như "Communications link failure" và làm hệ thống bị treo.

Trong hệ thống y tế cần hoạt động 24/7, việc này đặc biệt nguy hiểm vì có thể làm gián đoạn truy xuất hồ sơ bệnh nhân, ảnh hưởng trực tiếp đến việc khám chữa bệnh.
