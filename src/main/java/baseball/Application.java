package baseball;

import baseball.controller.Game;
import baseball.view.View;

public class Application {
    public static void main(String[] args) {
        try {
            Game game = new Game();
            game.run();
        } catch (IllegalArgumentException e) {
            View.errorMessage(e.getMessage());
            System.exit(0);
        }
    }
}
