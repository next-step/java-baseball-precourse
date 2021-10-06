package baseball.errors;

public class NotANumberException extends RuntimeException {
	public NotANumberException() {
		super("숫자를 입력해주세요");
	}
}
