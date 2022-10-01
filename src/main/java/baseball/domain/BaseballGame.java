package baseball.domain;

import baseball.domain.exceptions.BaseballIllegalArgumentException;
import baseball.ui.ConsoleView;

import static baseball.domain.ConsoleMessage.*;

public class BaseballGame {

    private final BaseballNumbers baseballNumbers;
    private BaseballGameStatus gameStatus = BaseballGameStatus.PLAYING;

    private BaseballGame(BaseballNumbers baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public static BaseballGame create() {
        return new BaseballGame(BaseballNumbers.generateRandomNumbers());
    }

    public BaseballNumbers getBaseballNumbers() {
        return baseballNumbers;
    }

    public void start() {
        while (gameStatus == BaseballGameStatus.PLAYING) {
            inputNumbersOfPlayer();
            ConsoleView.output(OUTPUT_BASEBALL_GAME_WIN);
            restart();
        }
    }

    private void inputNumbersOfPlayer() {
        BaseballScore baseballScore;
        do {
            String input = ConsoleView.input(INPUT_BASEBALL_GAME_START);
            baseballScore = calculateScore(input);
            ConsoleView.output(baseballScore.toString());
        } while (!baseballScore.isWin());
    }

    private BaseballScore calculateScore(String input) {
        BaseballNumbers baseballNumbersOfPlayer = BaseballNumbers.of(input);
        return baseballNumbers.calculateScore(baseballNumbersOfPlayer);
    }

    private void restart() {
        String input = ConsoleView.input(OUTPUT_BASEBALL_GAME_RESTART);
        changeGameStatus(input);
        generateNewBaseballNumbers();
    }

    private void changeGameStatus(String input) {
        gameStatus = BaseballGameStatus.of(input);
        if (gameStatus == BaseballGameStatus.ERROR) {
            throw new BaseballIllegalArgumentException(OUTPUT_BASEBALL_GAME_RESTART_ERROR);
        }
    }

    private void generateNewBaseballNumbers() {
        if (gameStatus == BaseballGameStatus.PLAYING) {
            baseballNumbers.generateRandomNumbersOfRestart();
        }
    }
}
