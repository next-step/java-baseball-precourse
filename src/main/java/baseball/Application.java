package baseball;

import baseball.controller.GameController;
import baseball.domain.Game;
import baseball.domain.RandomNumberGenerator;
import baseball.view.GameView;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        GameView view = new GameView();
        Game game = new Game(new RandomNumberGenerator());

        GameController controller = new GameController(view, game);
        controller.start();
    }
}
