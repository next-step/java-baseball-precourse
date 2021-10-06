package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import baseball.exception.DuplicationNumberException;
import baseball.exception.ErrorMessage;
import baseball.exception.NumberRangeInvalidException;

public class Numbers {
	private static final int RANGE_SIZE = 3;

	private final List<Number> number = new ArrayList<>();

	public Numbers(final String numbers) {
		validateRange(numbers);
		this.number.addAll(parse(numbers));
	}

	private List<Number> parse(final String numbers) {
		List<Number> tempDigits = new ArrayList<>();

		for (String numberStr : numbers.split("")) {
			Number numberValue = new Number(Integer.parseInt(numberStr));
			validateDuplicate(tempDigits, numberValue);
			tempDigits.add(numberValue);
		}

		return tempDigits;
	}

	private void validateRange(final String numbers) {
		if(numbers == null || numbers.length() != RANGE_SIZE) {
			throw new NumberRangeInvalidException(ErrorMessage.NUMBER_RANGE_INVALID_EXCEPTION.getMessage());
		}
	}

	private void validateDuplicate(final List<Number> tempDigits, Number number) {
		if (tempDigits.contains(number)) {
			throw new DuplicationNumberException(ErrorMessage.DUPLICATION_NUMBER_EXCEPTION.getMessage());
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Numbers numbers = (Numbers)o;
		return Objects.equals(number, numbers.number);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
