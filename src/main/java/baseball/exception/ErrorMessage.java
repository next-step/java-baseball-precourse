package baseball.exception;

public enum ErrorMessage {

	DUPLICATION_NUMBER_EXCEPTION("숫자는 중복 될 수 없습니다."),
	NUMBER_RANGE_INVALID_EXCEPTION("숫자는 3자리여야 합니다."),
	NUMBER_SIZE_INVALID_EXCEPTION("숫자 한칸의 값은 1부터 9사이만 됩니다.")

	;

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
