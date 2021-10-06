package baseball.domain.exceptions;

public class DuplicatedInputNumberException extends RuntimeException {

    public DuplicatedInputNumberException(String errMsg) {
        super(errMsg);
    }
}
