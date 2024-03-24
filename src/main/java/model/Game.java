package model;

public class Game {
	public final Answer answer = new Answer();
	public final Status status = new Status();

	public void initGame() {
		answer.setRandomNumberList();
		status.initCount();
	}

	public void updateCount(String input) {
		status.initCount();

		for (int i = 0; i < Answer.ANSWER_LENGTH; i++) {
			if (answer.isStrike(input.charAt(i) - '0', i + 1)) {
				status.increaseStrikeCount();
			}

			if (answer.isBall(input.charAt(i) - '0', i + 1)) {
				status.increaseBallCount();
			}
		}
	}
}