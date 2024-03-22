package model;

import java.util.List;

public class GameResult {

	private int numOfStrike = 0;
	private int numOfBall = 0;

	public GameResult(final String input, final List<Integer> answer) {
		final char[] inputNums = input.toCharArray();

		for (int i = 0; i < inputNums.length; i++) {
			final int num = Character.getNumericValue(inputNums[i]);
			final int position = answer.indexOf(num);

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
