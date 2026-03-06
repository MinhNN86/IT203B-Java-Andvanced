package Session01.LyThuyet;

public class CheckedException extends Exception{
    String message;
    int code;

    public CheckedException(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
