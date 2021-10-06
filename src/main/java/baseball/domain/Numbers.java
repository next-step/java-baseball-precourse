package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import baseball.exception.ErrorMessage;
import baseball.exception.DuplicationNumberException;
import baseball.exception.NumberRangeInvalidException;
import baseball.exception.NumberSizeInvalidException;

public class Numbers {

	private static final int MIN_NUMBER = 1;

	private static final int MAX_NUMBER = 9;

	private static final int RANGE_SIZE = 3;

	private final List<Integer> digits = new ArrayList<>();

	public Numbers(final String numbers) {
		validateRange(numbers);
		this.digits.addAll(parse(numbers));
	}

	private List<Integer> parse(final String numbers) {
		List<Integer> tempDigits = new ArrayList<>();

		for (String numberStr : numbers.split("")) {
			int number = Integer.parseInt(numberStr);
			validateSize(number);
			validateDuplicate(tempDigits, number);
			tempDigits.add(number);
		}

		return tempDigits;
	}

	private void validateRange(final String numbers) {
		if(numbers == null || numbers.length() != RANGE_SIZE) {
			throw new NumberRangeInvalidException(ErrorMessage.NUMBER_RANGE_INVALID_EXCEPTION.getMessage());
		}
	}

	private void validateDuplicate(final List<Integer> tempDigits, int number) {
		if (tempDigits.contains(number)) {
			throw new DuplicationNumberException(ErrorMessage.DUPLICATION_NUMBER_EXCEPTION.getMessage());
		}
	}

	private void validateSize(int number) {
		if(number < MIN_NUMBER || number > MAX_NUMBER) {
			throw new NumberSizeInvalidException(ErrorMessage.NUMBER_SIZE_INVALID_EXCEPTION.getMessage());
		}
	}

	public List<Integer> getDigits() {
		return Collections.unmodifiableList(this.digits);
	}
}
