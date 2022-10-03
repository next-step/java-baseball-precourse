package baseball;

import baseball.game.controller.GameController;

public class Application {
    public static void main(String[] args) {
        System.out.println( "game app");
        GameController gameController = new GameController();
        gameController.start();
    }
}
