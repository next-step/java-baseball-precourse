package baseball.controller;

import baseball.model.BaseBallGame;
import baseball.util.BallNumberUtil;

public class BaseballGameConrtoller {
	private BaseBallGame baseBallGame;

	public void initGame() {
		baseBallGame = new BaseBallGame(BallNumberUtil.createSelectedNumberList());
	}
}
