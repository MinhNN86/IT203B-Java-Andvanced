**Sự lãng phí tài nguyên khi dùng Statement trong vòng lặp:**

Khi sử dụng Statement và nối chuỗi SQL trong vòng lặp (ví dụ 1000 lần), Database phải thực hiện lại các bước:

1. **Parse (phân tích cú pháp)** câu lệnh SQL
2. **Generate Execution Plan (lập kế hoạch thực thi)**
3. **Execute (thực thi)**

👉 Điều này xảy ra **1000 lần**, dù cấu trúc câu SQL giống hệt nhau.

**Hậu quả:**

* Tốn CPU của Database Server
* Tăng thời gian xử lý
* Hiệu năng giảm nghiêm trọng

---

**Giải pháp với PreparedStatement:**

* SQL được **biên dịch trước (pre-compiled)** chỉ **1 lần**
* Các lần sau chỉ **truyền tham số và thực thi**

👉 Database **tái sử dụng Execution Plan**, không cần parse lại.

---

**Kết luận:**
PreparedStatement giúp:

* Giảm tải cho Database
* Tăng tốc độ xử lý
* Tối ưu hiệu năng rõ rệt khi xử lý số lượng lớn dữ liệu
