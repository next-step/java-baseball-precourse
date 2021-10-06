package baseball.domain;

import java.util.List;

public class Judge {

	private int containCounts = 0;
	private int strikeCounts = 0;

	public void countContainNumbers(BallNumbers computerNumber, BallNumbers userNumber) {
		List<Ball> numbers = userNumber.getBallNumbers();
		for (int i=0; i<numbers.size(); i++) {
			plusContains(computerNumber, numbers.get(i));
			plusStrikes(computerNumber, numbers.get(i), i);
		}
	}

	private void plusContains(BallNumbers computerNumber, Ball ballNumber) {
		if (computerNumber.isContains(ballNumber)) {
			containCounts++;
		}
	}

	private void plusStrikes(BallNumbers computerNumber, Ball ballNumber, int index) {
		if (computerNumber.isEqualFromIndex(ballNumber, index)) {
			strikeCounts++;
		}
	}

	public int strikeCount() {
		return strikeCounts;
	}

	public int ballCount() {
		return containCounts - strikeCounts;
	}

	public boolean isNothing() {
		return containCounts == 0;
	}
}
