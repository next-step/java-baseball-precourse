package baseball.domain.exception;

public class NumberRangeInvalidException extends RuntimeException {

	public NumberRangeInvalidException() {
	}

	public NumberRangeInvalidException(String message) {
		super(message);
	}

	public NumberRangeInvalidException(String message, Throwable cause) {
		super(message, cause);
	}

	public NumberRangeInvalidException(Throwable cause) {
		super(cause);
	}

	public NumberRangeInvalidException(String message, Throwable cause, boolean enableSuppression,
		boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
