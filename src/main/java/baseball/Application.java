package baseball;

import baseball.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        Boolean isContinue = true;

        while (isContinue == true) {
            isContinue = gameController.play();
        }
    }
}
