package baseball.message;

public enum ErrorMessage {
	INPUT_BALLS_ERROR("3자리의 1부터 9까지 서로 다른 수만 입력가능 합니다."),
	INPUT_ENDED_ERROR("1 또는 2만 입력 가능합니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}
