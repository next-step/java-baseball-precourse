package baseball.exception;

public class InvalidFiguresNumberException extends RuntimeException {
	public InvalidFiguresNumberException() {
		super(ErrorMessage.INVALID_FIGURES_NUMBER);
	}
}
