package baseball;

import baseball.controller.BullsAndGameController;

public class Application {
    public static void main(String[] args) {
        BullsAndGameController gameController = new BullsAndGameController();
        gameController.start();
    }
}
