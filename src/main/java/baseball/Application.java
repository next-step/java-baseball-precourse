package baseball;

import baseball.controller.BaseBallController;
import baseball.domain.BaseBallNumbersGenerator;
import baseball.domain.BaseBallUmpireProcessor;
import baseball.view.BaseBallConsole;

public class Application {
    public static void main(String[] args) {

        BaseBallController baseBallGameController = new BaseBallController(new BaseBallNumbersGenerator(),
                new BaseBallConsole(), new BaseBallUmpireProcessor());
        baseBallGameController.start();
    }
}
