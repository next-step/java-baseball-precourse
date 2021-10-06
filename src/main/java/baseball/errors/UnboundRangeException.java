package baseball.errors;

public class UnboundRangeException extends RuntimeException {
	public UnboundRangeException(int from, int to) {
		super("입력범위를 초과했습니다. " + from + "에서 " + to + "사이의 값을 입력해주세요");
	}
}
