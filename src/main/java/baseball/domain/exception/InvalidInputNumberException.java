package baseball.domain.exceptions;

public class InvalidInputNumberException extends RuntimeException {

    public InvalidInputNumberException(String errMsg) {
        super(errMsg);
    }
}
