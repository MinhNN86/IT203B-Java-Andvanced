package Session05.MiniProject.main.java.com.fastfood.model;

/**
 * Chi tiết một dòng trong đơn hàng (món + số lượng).
 */
public class OrderItem {
    private MenuItem menuItem;
    private int quantity;

    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /** Tiền của dòng này = giá * số lượng */
    public double getSubtotal() {
        return menuItem.calculatePrice() * quantity;
    }

    @Override
    public String toString() {
        return String.format("  %-30s x%2d = %,10.0f VND",
                menuItem.getName(), quantity, getSubtotal());
    }
}
