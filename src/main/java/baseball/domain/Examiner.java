package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;

public class Examiner {

	public Numbers getGoal() {
		return createNumbers();
	}

	private Numbers createNumbers() {
		List<Integer> numbers = new ArrayList<>();

		while(numbers.size() < 3) {
			createNumber(numbers);
		}

		return new Numbers(listToString(numbers));
	}

	private void createNumber(List<Integer> numbers) {
		int randomNumber = Randoms.pickNumberInRange(1, 9);

		if (!numbers.contains(randomNumber)) {
			numbers.add(randomNumber);
		}
	}

	private String listToString(List<Integer> numbers) {
		StringBuilder stringBuilder = new StringBuilder();

		for (Integer number : numbers) {
			stringBuilder.append(number);
		}

		return stringBuilder.toString();
	}

}
