## 📌 Phân tích bài toán

### 🎯 Input
- Không có input hoặc có thể có:
    - keyword tìm kiếm (String)

---

### 🎯 Output
- List<BenhNhanDTO>
    - maBenhNhan
    - tenBenhNhan
    - List<DichVu> dsDichVu

---

### ⚠️ Vấn đề hiện tại

- Số bệnh nhân ~500
- Mỗi lần load mất 10–15s

👉 Nguyên nhân: N+1 Query

---

### 🔥 Yêu cầu hệ thống

- Response time < 1s
- Không được mất bệnh nhân chưa có dịch vụ
- Không được lỗi NullPointerException

## 🔹 Giải pháp 1: N+1 Query (cách cũ)

1. 
```sql 
SELECT * FROM BenhNhan 
```
2. Với mỗi bệnh nhân:
```sql 
SELECT * FROM DichVuSuDung WHERE maBenhNhan = ? 
```

👉 Tổng query: 1 + N (≈ 501)

❌ Nhược:
- Rất chậm
- Quá tải DB

## 🔹 Giải pháp 2: JOIN (tối ưu)

```sql
SELECT bn.maBenhNhan, bn.tenBenhNhan,
dv.maDichVu, dv.tenDichVu
FROM BenhNhan bn
LEFT JOIN DichVuSuDung dv
ON bn.maBenhNhan = dv.maBenhNhan;
```


✅ Ưu:
- 1 query duy nhất
- Nhanh hơn rất nhiều

⚠️ Dùng LEFT JOIN để:
- Không mất bệnh nhân chưa có dịch vụ

## So sánh 
| Tiêu chí | N+1 Query | JOIN |
|--------|----------|------|
| Số query | 500+ | 1 |
| Hiệu năng | Rất chậm | Rất nhanh |
| Network I/O | Cao | Thấp |
| Code | Dễ | Trung bình |
| RAM | Thấp | Cao hơn chút |

👉 Chọn: **JOIN**

## 🔄 Các bước xử lý

1. Query JOIN
2. Tạo ```Map<maBenhNhan, BenhNhanDTO>```
3. Duyệt ResultSet:
    - Nếu chưa có → tạo DTO
    - Nếu có dịch vụ → add vào list
4. Trả về List DTO