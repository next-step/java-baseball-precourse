package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import baseball.ErrorMessage;
import baseball.exception.DuplicationNumberException;

public class Numbers {

	private final List<Integer> digits = new ArrayList<>();

	public Numbers(final String numbers) {
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

	private void validationDuplicate(final List<Integer> tempDigits, int number) {
		if (tempDigits.contains(number)) {
			throw new DuplicationNumberException(ErrorMessage.DUPLICATION_NUMBER_EXCEPTION.getMessage());
		}
	}

	public List<Integer> getDigits() {
		return Collections.unmodifiableList(this.digits);
	}
}
