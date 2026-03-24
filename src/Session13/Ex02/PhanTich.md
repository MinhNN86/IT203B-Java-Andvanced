## Trong code cũ:

```java
    catch (SQLException e) {
    System.out.println(e.getMessage());
    }
```
## 👉 Chỉ in lỗi → KHÔNG xử lý transaction

# Vấn đề nghiêm trọng:
### Đã setAutoCommit(false) → đang trong transaction
## Nhưng khi lỗi xảy ra:
### ❌ Không rollback
### ❌ Transaction bị treo (dangling transaction)
### ❌ Connection giữ trạng thái chưa commit/rollback
## ⚠️ Hậu quả:
### Lock database
### Tốn connection pool
### Có thể gây lỗi các request khác