package baseball;

import baseball.view.Game;

public class Application {

    private static Game game;

    public static void main(String[] args) {
        game = new Game();
        game.startGame();
    }
}
