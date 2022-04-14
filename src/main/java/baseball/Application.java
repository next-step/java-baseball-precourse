package baseball;

import baseball.constant.BaseballConfig;
import baseball.domain.BaseballGame;
import baseball.domain.BaseballNumberConfig;
import baseball.domain.decision.DefaultResultDecision;
import baseball.domain.decision.ResultDecision;
import baseball.domain.generator.NumberGenerator;
import baseball.domain.generator.RandomNumberGenerator;
import baseball.domain.validator.DefaultNumberValidator;
import baseball.domain.validator.NumberValidator;
import baseball.io.BaseballInput;
import baseball.io.BaseballOutput;
import baseball.io.ConsoleBaseballInput;
import baseball.io.ConsoleBaseballOutput;

public class Application {
    public static void main(String[] args) {
        BaseballNumberConfig config = new BaseballNumberConfig(BaseballConfig.START_RANDOM_NUMBER,
                                                               BaseballConfig.END_RANDOM_NUMBER,
                                                               BaseballConfig.NUMBER_COUNT);

        NumberGenerator numberGenerator = new RandomNumberGenerator(config);
        NumberValidator numberValidator = new DefaultNumberValidator(config);
        ResultDecision resultDecision = new DefaultResultDecision();

        BaseballInput input = new ConsoleBaseballInput();
        BaseballOutput output = new ConsoleBaseballOutput(System.out);

        BaseballGame baseballGame = new BaseballGame(config, numberGenerator, numberValidator, resultDecision,
                                                     input, output);
        baseballGame.start();
    }
}
