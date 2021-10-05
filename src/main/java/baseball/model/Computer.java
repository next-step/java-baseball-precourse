package baseball.model;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;

public class Computer {
	private final List<Integer> numbers = new ArrayList<>();

	public Computer() {
		createNumbers();
	}

	public int getStrikeCount(final List<Integer> playerNumbers) {
		int strikeCount = 0;
		for (int i = 0; i < 3; i++) {
			strikeCount += getMatchCount(playerNumbers.get(i), numbers.get(i));
		}
		return strikeCount;
	}

	public int getBallCount(final List<Integer> playerNumbers, final int strikeCount) {
		int ballCount = 0;
		for (int playerNumber : playerNumbers) {
			ballCount += getContainCount(playerNumber);
		}
		return ballCount - strikeCount;
	}

	private int getMatchCount(final int playerNumber, final int ComputerNumber) {
		if (playerNumber == ComputerNumber) {
			return 1;
		}
		return 0;
	}

	private int getContainCount(final int playerNumber) {
		if (numbers.contains(playerNumber)) {
			return 1;
		}
		return 0;
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
