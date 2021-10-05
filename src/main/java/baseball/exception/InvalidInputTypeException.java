package baseball.exception;

public class InvalidInputTypeException extends RuntimeException {
	public InvalidInputTypeException() {
		super(ErrorMessage.INVALID_INPUT_TYPE);
	}
}
