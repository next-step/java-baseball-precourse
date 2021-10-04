package baseball.exception;

public class NotMatchPickNumberSizeException extends RuntimeException {

    public NotMatchPickNumberSizeException() {
        super();
    }

    public NotMatchPickNumberSizeException(String errorMsg) {
        super(errorMsg);
    }
}
