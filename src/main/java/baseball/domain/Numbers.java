package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import baseball.exception.DuplicateNumberException;
import baseball.exception.InvalidNumbersSizeException;
import baseball.utils.CollectionUtils;

public class Numbers {
	public static final int SIZE = 3;

	private final List<Number> values;

	public Numbers(List<Integer> values) {
		checkValidValuesSize(values);
		for (Integer value : values) {
			checkDuplicateNumber(values, value);
		}

		List<Number> numbers = new ArrayList<>(SIZE);
		for (Integer value : values) {
			numbers.add(new Number(value));
		}
		this.values = Collections.unmodifiableList(numbers);
	}

	public boolean isContains(Number number) {
		return values.contains(number);
	}

	public int getNumberIndex(Number number) {
		return values.indexOf(number);
	}

	public Number get(int index) {
		return values.get(index);
	}

	public List<Number> getValues() {
		return values;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Numbers numbers = (Numbers)o;
		return Objects.equals(values, numbers.values);
	}

	@Override
	public int hashCode() {
		return Objects.hash(values);
	}

	private void checkValidValuesSize(List<Integer> values) {
		boolean isValid = !CollectionUtils.isEmpty(values) && values.size() == SIZE;
		if (!isValid) {
			throw new InvalidNumbersSizeException(SIZE);
		}
	}

	private void checkDuplicateNumber(List<Integer> values, Integer value) {
		boolean isValid = CollectionUtils.isUniqueElement(values, value);
		if (!isValid) {
			throw new DuplicateNumberException();
		}
	}
}
