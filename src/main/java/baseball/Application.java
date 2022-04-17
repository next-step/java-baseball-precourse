package baseball;

import baseball.game.BaseBallGame;
import baseball.game.Game;

public class Application {
    private static final Game Game = new BaseBallGame();

    public static void main(String[] args) {
        Game.start();
    }
}
