package baseball.domain;

import java.util.LinkedHashSet;
import java.util.Set;

import nextstep.utils.Randoms;

public class Computer {

	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private static final int SIZE = 3;

	public BallNumbers makeRandomNumbers() {
		Set<Ball> randomNumbers = new LinkedHashSet<>();

		while (randomNumbers.size() < SIZE) {
			randomNumbers.add(Ball.of(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)));
		}

		return BallNumbers.fromSet(randomNumbers);
	}
}