package baseball;

import baseball.controller.BaseballController;
import baseball.domain.number.BaseballNumbersGenerator;
import baseball.domain.number.DefaultNumberGenerateStrategy;
import baseball.view.BaseballUserInput;
import baseball.view.BaseballView;

public class Application {
    public static void main(String[] args) {
        BaseballController baseballController = new BaseballController(
                new BaseballNumbersGenerator(new DefaultNumberGenerateStrategy()),
                new BaseballUserInput(),
                new BaseballView()
        );
        baseballController.play();
    }
}
