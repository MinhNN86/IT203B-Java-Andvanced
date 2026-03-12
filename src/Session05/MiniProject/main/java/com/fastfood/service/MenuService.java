package Session05.MiniProject.main.java.com.fastfood.service;

import Session05.MiniProject.main.java.com.fastfood.exception.InsufficientStockException;
import Session05.MiniProject.main.java.com.fastfood.model.MenuItem;
import Session05.MiniProject.main.java.com.fastfood.repository.MenuRepository;
import Session05.MiniProject.main.java.com.fastfood.util.Validator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Logic nghiệp vụ cho danh mục món ăn.
 * Sử dụng Stream API để lọc, tìm kiếm.
 */
public class MenuService {
    private final MenuRepository repository;

    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }

    // ===== CRUD =====

    public void addMenuItem(MenuItem item) {
        Validator.validateMenuItem(item);
        repository.add(item);
    }

    public void removeMenuItem(String id) {
        repository.remove(id);
    }

    public void updateMenuItem(MenuItem item) {
        Validator.validateMenuItem(item);
        repository.update(item);
    }

    public List<MenuItem> getAllMenuItems() {
        return repository.findAll();
    }

    public Optional<MenuItem> findById(String id) {
        return repository.findById(id);
    }

    // ===== Stream API – Lọc / Tìm kiếm =====

    public List<MenuItem> filterByName(String keyword) {
        return repository.findAll().stream()
                .filter(item -> item.getName().toLowerCase()
                        .contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<MenuItem> filterByPriceRange(double minPrice, double maxPrice) {
        return repository.findAll().stream()
                .filter(item -> item.calculatePrice() >= minPrice
                        && item.calculatePrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    public List<MenuItem> filterByMaxPrice(double maxPrice) {
        return repository.findAll().stream()
                .filter(item -> item.calculatePrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    /** Giảm tồn kho khi thêm món vào đơn hàng. */
    public void reduceStock(String id, int quantity) throws InsufficientStockException {
        MenuItem item = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Không tìm thấy món với ID: " + id));
        if (item.getStock() < quantity) {
            throw new InsufficientStockException(
                    "Không đủ hàng tồn kho cho món: " + item.getName()
                            + " (còn: " + item.getStock() + ", yêu cầu: " + quantity + ")");
        }
        item.setStock(item.getStock() - quantity);
        repository.update(item);
    }

    /** Hoàn lại tồn kho khi hủy đơn hàng. */
    public void restoreStock(String id, int quantity) {
        repository.findById(id).ifPresent(item -> {
            item.setStock(item.getStock() + quantity);
            repository.update(item);
        });
    }
}
