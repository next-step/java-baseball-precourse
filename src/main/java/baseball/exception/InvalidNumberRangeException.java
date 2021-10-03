package baseball.exception;

public class InvalidNumberRangeException extends IllegalArgumentException {
	private static final String EXCEPTION_MESSAGE_FORMAT = "Each number(%d) has exceeded the allowed number range.";

	public InvalidNumberRangeException(int value) {
		super(String.format(EXCEPTION_MESSAGE_FORMAT, value));
	}
}
