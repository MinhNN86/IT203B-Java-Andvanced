package Session05.MiniProject.main.java.com.fastfood.exception;

/**
 * Ném khi số lượng món trong kho không đủ để thêm vào đơn hàng.
 */
public class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) {
        super(message);
    }
}
