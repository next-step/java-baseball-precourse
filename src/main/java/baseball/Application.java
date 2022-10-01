package baseball;

import baseball.controller.BaseballGame;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.start();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorInput();
            throw new IllegalArgumentException();
        }
    }
}
