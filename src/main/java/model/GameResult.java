package model;

import java.util.List;

public class GameResult {

	private int numOfStrike = 0;
	private int numOfBall = 0;

	public GameResult(final List<Integer> inputNums, final List<Integer> answer) {
		for (int i = 0; i < inputNums.size(); i++) {
			final int targetNum = inputNums.get(i);
			final int position = answer.indexOf(targetNum);

			if (position == -1) continue;
			if (position == i) {
				numOfStrike++;
				continue;
			}

			numOfBall++;
		}
	}

	public int getNumOfStrike() {
		return numOfStrike;
	}

	public int getNumOfBall() {
		return numOfBall;
	}
}
