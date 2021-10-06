package baseball.exception;

public class BaseballException extends RuntimeException{

    private ErrorMessage message;

    public BaseballException(ErrorMessage message) {
        super(message.getErrorMessage());
    }
}
