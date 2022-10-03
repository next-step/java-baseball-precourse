package baseball.game.controller;

import baseball.game.model.GameNumber;
import baseball.player.model.Player;


public class GameController {
    public void start() {
        Player player = new Player();

        while(player.keepPlaying()) {
            GameNumber numbers = new GameNumber();
            numbers.generateAnswer();
            System.out.println("playing...");
            player.enterNumber();
        }
    }
}
