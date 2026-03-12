package Session05.MiniProject.main.java.com.fastfood.util;

import Session05.MiniProject.main.java.com.fastfood.model.MenuItem;

/**
 * Kiểm tra tính hợp lệ của dữ liệu đầu vào.
 */
public class Validator {

    public static void validateMenuItem(MenuItem item) {
        if (item == null)
            throw new IllegalArgumentException("Món ăn không được null.");
        if (item.getId() == null || item.getId().trim().isEmpty())
            throw new IllegalArgumentException("ID món ăn không được để trống.");
        if (item.getName() == null || item.getName().trim().isEmpty())
            throw new IllegalArgumentException("Tên món ăn không được để trống.");
        if (item.getPrice() < 0)
            throw new IllegalArgumentException("Giá món ăn không được âm.");
        if (item.getStock() < 0)
            throw new IllegalArgumentException("Số lượng tồn kho không được âm.");
    }

    public static void validatePositiveInt(int value, String fieldName) {
        if (value <= 0)
            throw new IllegalArgumentException(fieldName + " phải là số nguyên dương.");
    }

    public static void validateNonEmpty(String value, String fieldName) {
        if (value == null || value.trim().isEmpty())
            throw new IllegalArgumentException(fieldName + " không được để trống.");
    }

    public static void validatePositiveDouble(double value, String fieldName) {
        if (value < 0)
            throw new IllegalArgumentException(fieldName + " không được âm.");
    }
}
