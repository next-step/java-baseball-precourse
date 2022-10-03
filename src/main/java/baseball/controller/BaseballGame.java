package baseball.controller;

import baseball.model.Game;
import baseball.model.Opponent;
import baseball.view.BaseballGameView;

public class BaseballGame {
	Game game;
	BaseballGameView view;

	public BaseballGame() {
		view = new BaseballGameView();
	}

	public boolean play() {
		String missionNum = new Opponent().getMissionNum();
		do {
			game = new Game(view.getUserInputNum(), missionNum);
			view.printMessage(game.checkScore().getResultMsg());
		} while (!game.isError() && !game.isCorrect());

		return !game.isError() && view.getUserInputEnd().equals("1");
	}
}
