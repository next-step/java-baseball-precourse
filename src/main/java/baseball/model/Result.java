package baseball.model;

import baseball.enums.ResultStatus;

public class Result {

	private final ResultStatus status;
	private final Score score;

	public Result(ResultStatus status, Score score) {
		this.status = status;
		this.score = score;
	}

	public static Result of(Score score) {
		if (score.isWin()) {
			return new Result(ResultStatus.WIN, score);
		}
		if (score.isNothing()) {
			return new Result(ResultStatus.NOTHING, score);
		}
		return new Result(ResultStatus.CONTINUE, score);
	}

	public int getStrike() {
		return score.getStrike();
	}

	public int getBall() {
		return score.getBall();
	}

	public ResultStatus getStatus() {
		return status;
	}
}
