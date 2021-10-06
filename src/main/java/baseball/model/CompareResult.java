package baseball.model;

public class CompareResult {
	private final int length;
	private int strike;
	private int ball;

	public CompareResult(int length) {
		this.length = length;
	}

	public void update(int i, int answerIndex) {
		if (answerIndex < 0) {
			return;
		}

		if (i == answerIndex) {
			strike++;
		}

		if (i != answerIndex) {
			ball++;
		}
	}

	public boolean isAnswer() {
		return length == strike;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}
}
