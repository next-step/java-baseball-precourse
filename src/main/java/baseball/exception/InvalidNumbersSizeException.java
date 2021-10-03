package baseball.exception;

public class InvalidNumbersSizeException extends IllegalArgumentException {

	private static final String EXCEPTION_MESSAGE = "The number of digits must be %d.";

	public InvalidNumbersSizeException(int size) {
		super(String.format(EXCEPTION_MESSAGE, size));
	}
}
