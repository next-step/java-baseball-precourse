package baseball.model;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;

public class Computer {
	private final List<Integer> numbers = new ArrayList<>();

	public Computer() {
		createNumbers();
	}

	private List<Integer> createNumbers() {
		addNumbers();
		return numbers;
	}

	private void addNumbers() {
		while (numbers.size() < 3) {
			addNotIncludedNumber(Randoms.pickNumberInRange(1, 9));
		}
	}

	private void addNotIncludedNumber(final int num) {
		if (!numbers.contains(num)) {
			numbers.add(num);
		}
	}
}
