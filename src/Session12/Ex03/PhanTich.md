**Tại sao phải gọi registerOutParameter() trước khi execute()?**

Trong JDBC, việc nhận dữ liệu từ tham số OUT **không tự động**, nên cần phải:

* **Đăng ký trước vị trí và kiểu dữ liệu** của tham số OUT bằng `registerOutParameter()`
* Giúp Database biết **Java đang chờ nhận kiểu dữ liệu gì**
* Nếu không đăng ký → sẽ xảy ra lỗi:

    * *Parameter not registered*
    * *Column index out of range*

👉 Vì vậy, đây là bước **bắt buộc** để lấy dữ liệu OUT.

---

**Nếu kiểu SQL là DECIMAL thì dùng gì trong Java?**

👉 Sử dụng:

* `Types.DECIMAL`
  (hoặc có thể dùng `Types.NUMERIC`)

---

**Kết luận:**
Phải đăng ký OUT trước khi execute và dùng đúng kiểu trong `java.sql.Types` để tránh lỗi.
