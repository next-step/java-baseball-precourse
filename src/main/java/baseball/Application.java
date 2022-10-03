package baseball;

import controller.GameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController =
                new GameController(3,1,9);
        gameController.run();
    }
}
