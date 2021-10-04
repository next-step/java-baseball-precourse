package baseball.utils;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import nextstep.utils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

	private final int numberSize;

	public RandomNumberGenerator(int numberSize) {
		this.numberSize = numberSize;
	}

	@Override
	public List<Integer> generate() {
		LinkedHashSet<Integer> numbers = new LinkedHashSet<>();

		while (numbers.size() < numberSize) {
			numbers.add(Randoms.pickNumberInRange(1, 9));
		}
		return new ArrayList<>(numbers);
	}
}
