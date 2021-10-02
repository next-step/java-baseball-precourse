package domain;

public enum MessageType {

	INVALID_DIGITS("세 자리수를 입력하세요."),
	INVALID_RANGE_OF_NUMBER("1~9 사이의 숫자만 입력하세요."),
	DUPLICATED_NUMBER("중복되지 않는 숫자를 입력하세요.");

	private String message;

	private MessageType(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
