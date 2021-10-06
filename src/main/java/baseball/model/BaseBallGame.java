package baseball.model;

import baseball.vo.BallNumberVo;

public class BaseBallGame {
	private final BallNumberVo ballNumber;

	public BaseBallGame(BallNumberVo ballNumber) {
		this.ballNumber = ballNumber;
	}

	public String submitBallNumber(BallNumberVo ballNumber) {
		return "RESULT";
	}
}
