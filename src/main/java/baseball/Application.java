package baseball;

import baseball.controller.BaseballController;
import baseball.model.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        BaseballController baseballController = new BaseballController(new RandomNumberGenerator());
        baseballController.start();
    }
}
