package baseball.exception;

public class BaseballGameException extends RuntimeException {

	public BaseballGameException(String message) {
		super(String.format("[ERROR]%s", message));
	}
}
