package baseball.exception;

public class DigitRangeOverException extends IllegalArgumentException {

	private static final String EXCEPTION_MESSAGE_FORMAT = "You have exceeded the number of digits.";

	public DigitRangeOverException() {
		super(EXCEPTION_MESSAGE_FORMAT);
	}
}
