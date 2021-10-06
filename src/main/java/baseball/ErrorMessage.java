package baseball;

public enum ErrorMessage {

	DUPLICATION_NUMBER_EXCEPTION("숫자는 중복 될 수 없습니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
