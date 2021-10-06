package baseball.domain;

import java.util.Objects;

import baseball.exception.ErrorMessage;
import baseball.exception.NumberSizeInvalidException;

public class Number {

	private static final int MIN_NUMBER = 1;

	private static final int MAX_NUMBER = 9;

	private final int value;

	public Number(int value) {
		validateSize(value);
		this.value = value;
	}

	private void validateSize(int number) {
		if(number < MIN_NUMBER || number > MAX_NUMBER) {
			throw new NumberSizeInvalidException(ErrorMessage.NUMBER_SIZE_INVALID_EXCEPTION.getMessage());
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Number number = (Number)o;
		return value == number.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
