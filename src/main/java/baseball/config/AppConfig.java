package baseball.config;

import baseball.controller.BaseballGameController;
import baseball.domain.BaseballGameFactory;
import baseball.domain.BaseballGameRule;
import baseball.domain.Computer;
import baseball.strategy.RandomUniqueNumberStrategy;
import baseball.ui.ConsoleInterface;
import baseball.ui.UserInterface;

public class AppConfig {

    public BaseballGameController baseballGameController() {
        return BaseballGameController.builder()
                .baseballGameFactory(baseballGameFactory())
                .userInterface(userInterface())
                .build();
    }

    public BaseballGameFactory baseballGameFactory() {
        return BaseballGameFactory.builder()
                .computer(computer())
                .baseballGameRule(baseballGameRule())
                .build();
    }

    public BaseballGameRule baseballGameRule() {
        return new BaseballGameRule();
    }

    public Computer computer() {
        return Computer.builder()
                .strategy(randomUniqueNumberStrategy()).build();
    }

    public RandomUniqueNumberStrategy randomUniqueNumberStrategy() {
        return RandomUniqueNumberStrategy.getInstance();
    }

    public UserInterface userInterface() {
        return ConsoleInterface.getInstance();
    }
}
