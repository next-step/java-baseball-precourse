package baseball.model;

import java.util.Objects;

import baseball.exception.DigitRangeOverException;
import baseball.exception.InvalidNumberRangeException;

public class Number {

	public static final int MIN_OF_VALUE = 1;
	public static final int MAX_OF_VALUE = 9;
	public static final int MIN_OF_DIGIT = 0;
	public static final int MAX_OF_DIGIT = 2;

	private int value;
	private int digit;

	public Number(int value, int digit) {
		checkValidValue(value);
		checkValidDigit(digit);
		this.value = value;
		this.digit = digit;
	}

	private void checkValidValue(int value) {
		boolean isValid = MIN_OF_VALUE <= value && value <= MAX_OF_VALUE;
		if (!isValid) {
			throw new InvalidNumberRangeException(value);
		}
	}

	private void checkValidDigit(int digit) {
		boolean isValid = MIN_OF_DIGIT <= digit && digit <= MAX_OF_DIGIT;
		if (!isValid) {
			throw new DigitRangeOverException();
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Number number = (Number)o;
		return value == number.value && digit == number.digit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value, digit);
	}
}
