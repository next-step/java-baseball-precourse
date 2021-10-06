package baseball.domain;

public class Checker {

	private int strike;

	private int ball;

	public void answerCheck(Numbers answer, Numbers goal) {
		initScore();

		for (int idx = 0; idx < Numbers.RANGE_SIZE; idx++) {
			compareNumbers(answer, goal, idx);
		}
	}

	private void initScore() {
		this.strike = 0;
		this.ball = 0;
	}

	private void compareNumbers(Numbers answer, Numbers goal, int idx) {
		if(!checkStrike(answer, goal, idx)) {
			checkBall(answer, goal, idx);
		}
	}

	private void checkBall(Numbers answer, Numbers goal, int idx) {
		if(answer.getNumber().contains(goal.getNumber().get(idx))) {
			this.ball++;
		}
	}

	private boolean checkStrike(Numbers answer, Numbers goal, int idx) {
		if(answer.getNumber().get(idx).equals(goal.getNumber().get(idx))) {
			this.strike++;
			return true;
		}

		return false;
	}

	public int getBall() {
		return ball;
	}

	public int getStrike() {
		return strike;
	}

	public boolean isAllStrike() {
		return this.strike == 3;
	}
}
