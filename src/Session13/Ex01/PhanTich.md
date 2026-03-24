# Phân tích lỗi transaction trong JDBC

## Nguyên nhân

Trong JDBC, mặc định `autoCommit = true`.

- Mỗi lần gọi `executeUpdate()` sẽ **tự động commit ngay lập tức**.
- Nếu câu lệnh sau bị lỗi thì các câu lệnh trước đó đã commit sẽ **không rollback được**.

## Luồng lỗi xảy ra

```java
stmt1.executeUpdate(); // da commit ngay
stmt2.executeUpdate(); // loi (vi du: mang chap chon)
```

## Kết quả

- Trừ kho: **đã commit**.
- Ghi lịch sử giao dịch: **thất bại**.

## Hệ quả

- Mất đồng nhất dữ liệu.
- Sai nghiệp vụ.
- Vi phạm tính **Atomicity** trong ACID.
