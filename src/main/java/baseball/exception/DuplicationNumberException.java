package baseball.exception;

public class DuplicationNumberException extends RuntimeException {

	public DuplicationNumberException() {
		super();
	}

	public DuplicationNumberException(String message) {
		super(message);
	}

	public DuplicationNumberException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicationNumberException(Throwable cause) {
		super(cause);
	}

	protected DuplicationNumberException(String message, Throwable cause, boolean enableSuppression,
		boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
