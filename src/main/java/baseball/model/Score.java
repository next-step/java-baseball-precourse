package baseball.model;

import baseball.utils.Constants;

public class Score {
	boolean isCorrect;
	int strike, ball;
	String resultMsg = "";

	public String getResultMsg() {
		return resultMsg;
	}

	public void getResult() {
		if (check3Strike()) return;
		if (checkNothing()) return;
		if (ball > 0) resultMsg = String.format("%d볼 ", ball);
		if (strike > 0) resultMsg += String.format("%d스트라이크", strike);
		resultMsg += "\n";
	}

	private	boolean check3Strike() {
		if (strike == Constants.RAND_NUM_SIZE) {
			isCorrect = true;
			resultMsg = "3스트라이크\n" + Constants.CORRECT_MESSAGE;
			return true;
		}
		return false;
	}

	private	boolean checkNothing() {
		if (strike == 0 && ball == 0) {
			resultMsg = "낫싱\n";
			return true;
		}
		return false;
	}
}
