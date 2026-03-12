package Session05.MiniProject.main.java.com.fastfood.exception;

/**
 * Ném khi không tìm thấy đơn hàng với ID cho trước.
 */
public class InvalidOrderIdException extends Exception {
    public InvalidOrderIdException(String message) {
        super(message);
    }
}
