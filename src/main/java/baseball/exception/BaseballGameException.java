package baseball.exception;

public class BaseballGameException extends RuntimeException {

    public BaseballGameException() {
        super();
    }

    public BaseballGameException(String message) {
        super(message);
    }

    public BaseballGameException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseballGameException(Throwable cause) {
        super(cause);
    }
}
