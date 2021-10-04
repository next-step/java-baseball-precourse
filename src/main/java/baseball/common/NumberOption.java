package baseball.common;

public enum NumberOption {
	ZERO(0),
	MAX_SIZE(3),
	MAX_NUMBER(9),
	MIN_NUMBER(1);

	private final int value;

	NumberOption(int value) {
		this.value = value;
	}

	public boolean isEqualValue(int input) {
		return this.value == input;
	}

	public int getValue() {
		return value;
	}
}
