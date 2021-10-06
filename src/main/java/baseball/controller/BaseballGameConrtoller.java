package baseball.controller;

import baseball.exception.InvalidBallNumberException;
import baseball.model.BaseBallGame;
import baseball.util.BallNumberUtil;
import baseball.vo.BallNumberVo;
import baseball.vo.GameResultVo;
import baseball.vo.SubmitBallNumberResponseVo;

public class BaseballGameConrtoller {
	private BaseBallGame baseBallGame;

	public void initGame() {
		baseBallGame = new BaseBallGame(BallNumberUtil.createBallNumber());
	}

	public SubmitBallNumberResponseVo submitBallNumberStr(String str) {
		SubmitBallNumberResponseVo response = new SubmitBallNumberResponseVo();
		try {
			BallNumberVo ballNumber = BallNumberUtil.stringToBallNumber(str);
			baseBallGame.submitBallNumber(ballNumber);
			GameResultVo gameResult = baseBallGame.getGameResult();
			response.setGameResult(gameResult);
			response.setStatus("SUCCESS");
		} catch (InvalidBallNumberException e) {
			response.setStatus("ERROR");
		}
		return response;
	}
}
