package baseball;

import baseball.controller.BaseballController;
import baseball.controller.impl.BaseballControllerImpl;

public class Application {
    public static void main(String[] args) {
        BaseballController baseballController = new BaseballControllerImpl();
        baseballController.start();
    }
}
