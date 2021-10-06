package baseball.exception;

public class InvalidSelectValueException extends RuntimeException {
	public InvalidSelectValueException() {
		super(ErrorMessage.INVALID_SELECT_VALUE);
	}
}
