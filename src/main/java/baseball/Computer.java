package baseball;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;

public class Computer {
	private static final int NUMBER_SIZE = 3;
	private static final int NUMBER_RANGE_MIN = 1;
	private static final int NUMBER_RANGE_MAX = 9;

	public BaseballNumbers createBaseballNumbers() {
		List<Integer> randomNumbers = new ArrayList<>();

		while (randomNumbers.size() < NUMBER_SIZE) {
			int number = Randoms.pickNumberInRange(NUMBER_RANGE_MIN, NUMBER_RANGE_MAX);
			if (!randomNumbers.contains(number)) {
				randomNumbers.add(number);
			}
		}

		return new BaseballNumbers(randomNumbers);
	}
}
