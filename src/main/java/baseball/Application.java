package baseball;

import baseball.controller.GameController;
import baseball.service.GameService;
import baseball.view.GameView;

public class Application {
	public static void main(String[] args) {
		// TODO 숫자 야구 게임 구현
		GameView gameView = new GameView();
		GameService gameService = new GameService();
		GameController gameController = new GameController(gameView, gameService);
		gameController.index();
	}
}
