package Session05.MiniProject.test.java.com.fastfood;

import Session05.MiniProject.main.java.com.fastfood.exception.InsufficientStockException;
import Session05.MiniProject.main.java.com.fastfood.model.Drink;
import Session05.MiniProject.main.java.com.fastfood.model.Food;
import Session05.MiniProject.main.java.com.fastfood.model.MenuItem;
import Session05.MiniProject.main.java.com.fastfood.repository.MenuRepository;
import Session05.MiniProject.main.java.com.fastfood.service.MenuService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenuServiceTest {

    private MenuService menuService;

    @BeforeEach
    void setUp() {
        menuService = new MenuService(new MenuRepository());
        menuService.addMenuItem(new Food("F001", "Hamburger Bò", 45000, 100, "Burger"));
        menuService.addMenuItem(new Food("F002", "Gà Rán Giòn", 35000, 150, "Gà"));
        menuService.addMenuItem(new Food("F003", "Pizza Hải Sản", 80000, 50, "Pizza"));
        menuService.addMenuItem(new Drink("D001", "Coca Cola", 15000, 200, Drink.DrinkSize.M));
    }

    @Test
    @DisplayName("Thêm 4 món vào menu → danh sách có đúng 4 phần tử")
    void testAddMenuItem_increasesListSize() {
        assertEquals(4, menuService.getAllMenuItems().size());
    }

    @Test
    @DisplayName("Xóa món khỏi menu → danh sách giảm và không còn tìm thấy")
    void testRemoveMenuItem_decreasesListSize() {
        menuService.removeMenuItem("F001");
        assertEquals(3, menuService.getAllMenuItems().size());
        assertFalse(menuService.findById("F001").isPresent());
    }

    @Test
    @DisplayName("Cập nhật món → tên được thay đổi đúng")
    void testUpdateMenuItem_changesName() {
        MenuItem item = menuService.findById("F001").get();
        item.setName("Hamburger Đặc Biệt");
        menuService.updateMenuItem(item);
        assertEquals("Hamburger Đặc Biệt", menuService.findById("F001").get().getName());
    }

    @Test
    @DisplayName("Thêm món với ID rỗng → ném IllegalArgumentException")
    void testAddMenuItem_invalidId_throwsException() {
        assertThrows(IllegalArgumentException.class,
                () -> menuService.addMenuItem(new Food("", "Tên", 10000, 5, "Cat")));
    }

    @Test
    @DisplayName("Thêm món với giá âm → ném IllegalArgumentException")
    void testAddMenuItem_negativePrice_throwsException() {
        assertThrows(IllegalArgumentException.class,
                () -> menuService.addMenuItem(new Food("X1", "Test", -1000, 5, "Cat")));
    }

    @Test
    @DisplayName("Tìm kiếm tên không phân biệt hoa/thường → trả kết quả đúng")
    void testFilterByName_caseSensitivity() {
        List<MenuItem> result = menuService.filterByName("hamburger");
        assertEquals(1, result.size());
        assertEquals("F001", result.get(0).getId());
    }

    @Test
    @DisplayName("Lọc theo khoảng giá 30k-50k → đếm đúng số món")
    void testFilterByPriceRange_correctCount() {
        List<MenuItem> result = menuService.filterByPriceRange(30000, 50000);
        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("Lọc giá tối đa → Drink được tính theo giá thực (có hệ số size)")
    void testFilterByMaxPrice_includesDrinkCalculatedPrice() {
        // D001: 15000 * 1.2 (size M) = 18000 ≤ 20000
        List<MenuItem> result = menuService.filterByMaxPrice(20000);
        assertTrue(result.stream().anyMatch(i -> i.getId().equals("D001")));
    }

    @Test
    @DisplayName("Giảm tồn kho 10 đơn vị → số lượng còn lại đúng")
    void testReduceStock_updatesCorrectly() throws InsufficientStockException {
        menuService.reduceStock("F001", 10);
        assertEquals(90, menuService.findById("F001").get().getStock());
    }

    @Test
    @DisplayName("Giảm tồn kho vượt quá số lượng → ném InsufficientStockException")
    void testReduceStock_insufficientThrowsException() {
        assertThrows(InsufficientStockException.class,
                () -> menuService.reduceStock("F001", 200));
    }

    @Test
    @DisplayName("Hoàn lại tồn kho sau khi giảm → số lượng khôi phục về ban đầu")
    void testRestoreStock_updatesCorrectly() throws InsufficientStockException {
        menuService.reduceStock("F001", 10);
        menuService.restoreStock("F001", 10);
        assertEquals(100, menuService.findById("F001").get().getStock());
    }

    @Test
    @DisplayName("Drink size M → giá tính = giá gốc × 1.2")
    void testDrinkCalculatePrice_sizeM() {
        MenuItem d = menuService.findById("D001").get();
        assertEquals(18000.0, d.calculatePrice(), 0.01);
    }

    @Test
    @DisplayName("Drink size L → giá tính = giá gốc × 1.5")
    void testDrinkCalculatePrice_sizeL() {
        menuService.addMenuItem(new Drink("D002", "Nước Cam", 20000, 100, Drink.DrinkSize.L));
        MenuItem d = menuService.findById("D002").get();
        assertEquals(30000.0, d.calculatePrice(), 0.01);
    }

    @Test
    @DisplayName("Drink size S → giá tính = giá gốc (hệ số 1.0)")
    void testDrinkCalculatePrice_sizeS() {
        menuService.addMenuItem(new Drink("D003", "Nước Suối", 10000, 100, Drink.DrinkSize.S));
        MenuItem d = menuService.findById("D003").get();
        assertEquals(10000.0, d.calculatePrice(), 0.01);
    }
}
