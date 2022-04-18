package baseball;

import baseball.domain.Game;
import baseball.domain.Player;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(Player.createPlayer());
        game.createGame();
    }
}
