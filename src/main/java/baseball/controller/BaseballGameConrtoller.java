package baseball.controller;

import baseball.exception.InvalidBallNumberException;
import baseball.model.BaseBallGame;
import baseball.util.BallNumberUtil;
import baseball.vo.BallNumberVo;

public class BaseballGameConrtoller {
	private BaseBallGame baseBallGame;

	public void initGame() {
		baseBallGame = new BaseBallGame(BallNumberUtil.createBallNumber());
	}

	public String submitBallNumberStr(String str) {
		String gameResult = "";
		try {
			BallNumberVo ballNumber = BallNumberUtil.stringToBallNumber(str);
			gameResult = baseBallGame.submitBallNumber(ballNumber);
		} catch (InvalidBallNumberException e) {
			gameResult = "InvalidBallNumberException";
		}
		return gameResult;
	}
}
