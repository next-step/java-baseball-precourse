package baseball;

import baseball.controller.BaseBallController;
import baseball.service.BaseBallService;

public class Application {
    public static void main(String[] args) {
        BaseBallController baseBallController = new BaseBallController(new BaseBallService());
        new BaseBallGame(baseBallController).run();
    }
}
