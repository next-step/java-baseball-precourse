package baseball;

import baseball.game.BaseBallGame;
import baseball.game.Game;

public class Application {
    public static void main(String[] args) {
        Game Game = new BaseBallGame();
        Game.start();
    }
}
