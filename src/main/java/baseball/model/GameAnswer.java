package baseball.model;

import nextstep.utils.Randoms;

public class GameAnswer {
	private final int[] answer;
	private static final int LENGTH = 3;

	public GameAnswer() {
		this.answer = new int[LENGTH];
	}

	public void generateAnswer() {
		boolean[] generated = new boolean[9];
		for (int i = 0; i < LENGTH; i++) {
			int number = findNotDuplicateRandomNumber(generated);
			answer[i] = number;
		}
	}

	public CompareResult compare(int[] userAnswer) {
		CompareResult result = new CompareResult(LENGTH);
		for (int i = 0; i < userAnswer.length; i++) {
			int answerIndex = getAnswerIndex(userAnswer[i]);
			result.update(i, answerIndex);
		}

		return result;
	}

	private int getAnswerIndex(int value) {
		int position = -1;
		for (int i = 0 ; i < answer.length; i++) {
			position = answer[i] == value ? i : position;
		}

		return position;
	}

	private int findNotDuplicateRandomNumber(boolean[] generated) {
		int i = -1;
		do {
			i = Randoms.pickNumberInRange(1, 9) - 1;
		} while (generated[i]);
		generated[i] = true;
		return i + 1;
	}
}
