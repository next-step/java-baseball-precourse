package baseball.domain;

public class BaseballGame {

	private final String answer;

	private BaseballGameScoreBoard board;

	public BaseballGame(String answer) {
		this.answer = answer;
	}

	public BaseballGameScoreBoard deal(String input) {

		BaseballGameScoreBoard board = new BaseballGameScoreBoard();

		String[] split = input.split("");

		for (int i = 0; i < split.length; i++) {
			board.update(judge(i, split[i]));
		}

		this.board = board;

		return board;
	}

	public boolean isContinue() {
		return !board.isThreeStrikes();
	}

	private BaseballGameScore judge(int index, String value) {

		if (isContainsValueWithSamePosition(index, value)) {
			return BaseballGameScore.STRIKE;
		}

		if (isContainsValueButNotSamePosition(index, value)) {
			return BaseballGameScore.BALL;
		}

		return BaseballGameScore.NOTHING;
	}

	private boolean isContainsValueWithSamePosition(int index, String value) {
		return answer.indexOf(value) == index;
	}

	private boolean isContainsValueButNotSamePosition(int index, String value) {
		return answer.contains(value) && answer.indexOf(value) != index;
	}
}
