package Session05.MiniProject.main.java.com.fastfood.repository;

import Session05.MiniProject.main.java.com.fastfood.model.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Lưu trữ danh sách món ăn trong bộ nhớ (ArrayList).
 */
public class MenuRepository {
    private final List<MenuItem> menuItems = new ArrayList<>();

    public void add(MenuItem item) {
        menuItems.add(item);
    }

    public void remove(String id) {
        menuItems.removeIf(item -> item.getId().equals(id));
    }

    /** Thay thế item theo ID (dùng để cập nhật). */
    public void update(MenuItem updatedItem) {
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).getId().equals(updatedItem.getId())) {
                menuItems.set(i, updatedItem);
                return;
            }
        }
    }

    public Optional<MenuItem> findById(String id) {
        return menuItems.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }

    public List<MenuItem> findAll() {
        return new ArrayList<>(menuItems);
    }
}
