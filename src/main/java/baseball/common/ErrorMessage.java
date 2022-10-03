package baseball.common;

/**
 * @author garden.iee
 */
public enum ErrorMessage {

	INPUT_NOT_ALLOW_BLANK("사용자 입력은 공백을 포함할 수 없습니다."),
	INPUT_ONLY_ALLOW_NUMBERS("숫자만 입력할 수 있습니다."),
	INPUT_ONLY_ALLOW_THREE_DIGITS("3개의 수를 입력해야 합니다."),
	INPUT_NOT_ALLOW_DUPLICATE("서로 다른 임의의 수 3개를 입력해야 합니다.");

	private final String message;

	ErrorMessage(final String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}