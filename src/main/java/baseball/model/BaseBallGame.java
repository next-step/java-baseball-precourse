package baseball.model;

import baseball.util.BallNumberUtil;
import baseball.vo.BallNumberVo;
import baseball.vo.GameResultVo;

public class BaseBallGame {
	private final BallNumberVo ballNumber;
	private BallNumberVo submitBallNumber;
	private GameResultVo gameResult;

	public BaseBallGame(BallNumberVo ballNumber) {
		this.ballNumber = ballNumber;
	}

	public void submitBallNumber(BallNumberVo ballNumber) {
		this.submitBallNumber = ballNumber;
		makeGameResult();
	}

	private void makeGameResult() {
		GameResultVo gameResult = new GameResultVo();
		gameResult.setBall(BallNumberUtil.getBallBetweenBallNumber(this.ballNumber, this.submitBallNumber));
		gameResult.setStrike(BallNumberUtil.getStrikeBetweenBallNumber(this.ballNumber, this.submitBallNumber));
		this.gameResult = gameResult;
	}

	public BallNumberVo getSubmitBallNumber() {
		return submitBallNumber;
	}

	public void setSubmitBallNumber(BallNumberVo submitBallNumber) {
		this.submitBallNumber = submitBallNumber;
	}

	public GameResultVo getGameResult() {
		return gameResult;
	}
}
