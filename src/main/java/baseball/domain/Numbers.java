package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import baseball.domain.exception.ErrorMessage;
import baseball.domain.exception.DuplicationNumberException;
import baseball.domain.exception.NumberRangeInvalidException;

public class Numbers {

	private final static Integer NUMBERS_SIZE = 3;

	private final List<Integer> digits = new ArrayList<>();

	public Numbers(final String numbers) {
		validateRange(numbers);
		this.digits.addAll(parse(numbers));
	}

	private List<Integer> parse(final String numbers) {
		List<Integer> tempDigits = new ArrayList<>();

		for (String numberStr : numbers.split("")) {
			int number = Integer.parseInt(numberStr);
			validationDuplicate(tempDigits, number);
			tempDigits.add(number);
		}

		return tempDigits;
	}

	private void validateRange(final String numbers) {
		if(numbers == null || numbers.length() != NUMBERS_SIZE) {
			throw new NumberRangeInvalidException(ErrorMessage.NUMBER_RANGE_INVALID_EXCEPTION.getMessage());
		}
	}

	private void validationDuplicate(final List<Integer> tempDigits, int number) {
		if (tempDigits.contains(number)) {
			throw new DuplicationNumberException(ErrorMessage.DUPLICATION_NUMBER_EXCEPTION.getMessage());
		}
	}

	public List<Integer> getDigits() {
		return Collections.unmodifiableList(this.digits);
	}
}
