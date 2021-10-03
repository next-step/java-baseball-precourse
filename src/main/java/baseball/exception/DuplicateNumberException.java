package baseball.exception;

public class DuplicateNumberException extends IllegalArgumentException {

	private static final String EXCEPTION_MESSAGE = "Duplicate numbers are not available.";

	public DuplicateNumberException() {
		super(EXCEPTION_MESSAGE);
	}
}