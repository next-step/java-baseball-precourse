package baseball;

import baseball.controller.Game;
import baseball.view.GameView;
import baseball.view.UserInputReader;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameView gameView = new GameView(new UserInputReader());
        new Game(gameView).play();
    }
}
