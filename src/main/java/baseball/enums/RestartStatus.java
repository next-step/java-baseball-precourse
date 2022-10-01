package baseball.enums;

public enum RestartStatus {
	RESTART("1"),
	END("2");

	private final String code;

	RestartStatus(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
