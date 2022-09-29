package baseball;

import baseball.controller.GameHost;

public class Application {
    public static void main(String[] args) {
        GameHost game = new GameHost();
        game.startGame();
    }
}
