package baseball.domain;

import baseball.constant.BaseballMessages;
import baseball.constant.BaseballRestartStatus;
import baseball.domain.decision.ResultDecision;
import baseball.domain.generator.NumberGenerator;
import baseball.domain.validator.NumberValidator;
import baseball.io.BaseballInput;
import baseball.io.BaseballOutput;
import baseball.util.NumberUtil;

import java.util.List;

public class BaseballGame {
    private final BaseballNumberConfig numberConfig;
    private final NumberGenerator numberGenerator;
    private final NumberValidator numberValidator;
    private final ResultDecision resultDecision;

    private final BaseballInput input;
    private final BaseballOutput output;

    public BaseballGame(BaseballNumberConfig numberConfig, NumberGenerator numberGenerator,
                        NumberValidator numberValidator, ResultDecision resultDecision,
                        BaseballInput input, BaseballOutput output) {
        this.numberConfig = numberConfig;
        this.numberGenerator = numberGenerator;
        this.numberValidator = numberValidator;
        this.resultDecision = resultDecision;
        this.input = input;
        this.output = output;
    }

    public void start() {
        BaseballNumber computerNumber = makeComputerNumber();

        challenge(computerNumber);
    }

    private BaseballNumber makeComputerNumber() {
        List<Integer> numbers = generateNumbers();

        validateNumbers(numbers);

        return new BaseballNumber(numbers);
    }

    private List<Integer> generateNumbers() {
        return numberGenerator.generateNumbers();
    }

    private void validateNumbers(List<Integer> numbers) {
        numberValidator.validate(numbers);
    }

    private void challenge(BaseballNumber computerNumber) {
        BaseballNumber userNumber = getUserNumber();

        BaseballResult result = getResult(computerNumber, userNumber);
        showResult(result);

        boolean passed = result.isPassed(numberConfig.getNumberCount());
        if (passed) {
            passedChallenge();
            return;
        }

        challenge(computerNumber);
    }

    private BaseballResult getResult(BaseballNumber computerNumber, BaseballNumber userNumber) {
        return resultDecision.decide(computerNumber, userNumber);
    }

    private BaseballNumber getUserNumber() {
        showInputNumberMessage();

        String text = input.read();
        List<Integer> numbers = NumberUtil.convertStringToIntegerList(text);

        validateNumbers(numbers);

        return new BaseballNumber(numbers);
    }

    private void showInputNumberMessage() {
        output.write(BaseballMessages.INPUT_NUMBERS);
    }

    private void showResult(BaseballResult result) {
        String resultMessage = result.getMessage();
        output.writeln(resultMessage);
    }

    private void passedChallenge() {
        showPassedMessage();
        askRestart();
    }

    private void showPassedMessage() {
        output.writeln(String.format(BaseballMessages.OUTPUT_GAME_PASSED, numberConfig.getNumberCount()));
    }

    private void askRestart() {
        showRestartMessage();

        String text = input.read();
        if (BaseballRestartStatus.isRestart(text)) {
            start();
            return;
        }
        if (BaseballRestartStatus.isWrong(text)) {
            askRestart(); // 1, 2가 아니면 다시 물어본다.
        }
    }

    private void showRestartMessage() {
        String restartY = BaseballRestartStatus.Y.getValue();
        String restartN = BaseballRestartStatus.N.getValue();
        output.writeln(String.format(BaseballMessages.INPUT_RESTART, restartY, restartN));
    }
}
