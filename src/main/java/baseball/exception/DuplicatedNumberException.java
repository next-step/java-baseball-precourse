package baseball.exception;

public class DuplicatedNumberException extends RuntimeException {

	public DuplicatedNumberException() {
		super(ErrorMessage.DUPLICATED_NUMBER);
	}
}
