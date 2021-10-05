package baseball.domain;

import java.util.Objects;

import baseball.exception.InvalidNumberRangeException;

public class Number {
	public static final int MIN = 1;
	public static final int MAX = 9;

	private final int value;

	public Number(int value) {
		checkValidValue(value);
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Number number = (Number)o;
		return value == number.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	private void checkValidValue(int value) {
		boolean isValid = MIN <= value && value <= MAX;
		if (!isValid) {
			throw new InvalidNumberRangeException(value);
		}
	}
}
