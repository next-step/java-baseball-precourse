package baseball.errors;

public class InvalidLengthException extends RuntimeException {
	public InvalidLengthException(int length) {
		super("길이가 잘못되었습니다. " + length + "만큼 입력해주세요");
	}
}
