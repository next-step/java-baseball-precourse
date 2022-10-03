package baseball.model;

import baseball.utils.Constants;

public class Game {
	private String userNum;
	private String missionNum;
	private Score score;
	private boolean isError;

	public Game(String inputNum, String missionNum) {
		this.userNum = inputNum;
		this.missionNum = missionNum;
		this.isError = inputNum == null;
	}

	public boolean isCorrect() {
		return score.isCorrect;
	}

	public boolean isError() {
		return this.isError;
	}

	public Score checkScore() {
		score = new Score();

		for (int i = 0; i < Constants.RAND_NUM_SIZE; i++) {
			checkStrikeBall(userNum.charAt(i), i);
		}
		score.getResult();
		return score;
	}

	private void checkStrikeBall(char c, int index) {
		if (missionNum.charAt(index) == c) {
			score.strike++;
			return;
		}

		if (missionNum.indexOf(c) >= 0) {
			score.ball++;
		}
	}
}
