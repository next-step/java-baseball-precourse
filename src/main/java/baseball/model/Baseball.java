package baseball.model;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;

public class Baseball {
	private List<Integer> numbers = new ArrayList<>();
	private final int sizeOfNumbers = 3;

	private static final Baseball instance = new Baseball();

	public static Baseball getInstance() {
		return instance;
	}

	public void initialize() {
		initNumbers();
	}

	private void initNumbers() {
		numbers.clear();

		while (numbers.size() < sizeOfNumbers) {
			addRandomNumber();
		}
	}

	private void addRandomNumber() {
		int randomNumber = Randoms.pickNumberInRange(1, 9);
		if (!numbers.contains(randomNumber)) {
			numbers.add(randomNumber);
		}
	}
}
