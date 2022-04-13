package baseball.domain;

import baseball.constant.BaseballMessages;
import baseball.constant.BaseballRestartStatus;
import baseball.io.BaseballInput;
import baseball.io.BaseballOutput;
import baseball.util.NumberUtil;

import java.util.List;

public class BaseballGame {
    private static final int START_RANDOM_NUMBER = 1;
    private static final int END_RANDOM_NUMBER = 9;
    private static final int NUMBER_COUNT = 3;

    private final BaseballInput input;
    private final BaseballOutput output;

    private final BaseballNumberValidator validator;

    public BaseballGame(BaseballInput input, BaseballOutput output) {
        this.input = input;
        this.output = output;

        this.validator = new BaseballNumberValidator(START_RANDOM_NUMBER, END_RANDOM_NUMBER, NUMBER_COUNT);
    }

    public void start() {
        BaseballDecision decision = makeDecision();

        challenge(decision);
    }

    private BaseballDecision makeDecision() {
        BaseballNumber computerNumber = makeComputerNumber();

        return new BaseballDecision(computerNumber);
    }

    private BaseballNumber makeComputerNumber() {
        List<Integer> numbers = generateRandomNumbers();
        return new BaseballNumber(numbers, validator);
    }

    private List<Integer> generateRandomNumbers() {
        return NumberUtil.pickUniqueNumbers(START_RANDOM_NUMBER, END_RANDOM_NUMBER, NUMBER_COUNT);
    }

    private void challenge(BaseballDecision decision) {
        BaseballNumber userNumber = getUserNumber();

        BaseballResult result = decision.getResult(userNumber);
        showResult(result);

        boolean passed = result.isPassed(NUMBER_COUNT);
        if (passed) {
            passedChallenge();
            return;
        }

        challenge(decision);
    }

    private BaseballNumber getUserNumber() {
        showInputNumberMessage();

        String text = input.read();
        List<Integer> numbers = NumberUtil.convertStringToIntegerList(text);

        return new BaseballNumber(numbers, validator);
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
        output.writeln(String.format(BaseballMessages.OUTPUT_GAME_PASSED, NUMBER_COUNT));
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
