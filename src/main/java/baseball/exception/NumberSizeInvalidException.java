package baseball.exception;

public class NumberSizeInvalidException extends RuntimeException {
	public NumberSizeInvalidException() {
	}

	public NumberSizeInvalidException(String message) {
		super(message);
	}

	public NumberSizeInvalidException(String message, Throwable cause) {
		super(message, cause);
	}

	public NumberSizeInvalidException(Throwable cause) {
		super(cause);
	}

	public NumberSizeInvalidException(String message, Throwable cause, boolean enableSuppression,
		boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
