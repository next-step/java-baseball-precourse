package baseball;

import baseball.domain.GameState;
import baseball.controller.BaseBallGameController;
import baseball.model.OptionInput;

public class Application {

    public static void main(String[] args) {
        GameState gameState = GameState.START;

        while (gameState == GameState.START) {
            BaseBallGameController play = new BaseBallGameController();
            play.run();
            gameState = new OptionInput().getOption();
        }
    }
}
