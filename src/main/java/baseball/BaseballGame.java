package baseball;

import java.util.function.Supplier;

/**
 * 야구게임 실행기.
 * play : 야구게임이 실행되며, 성공할 때까지 수행됩니다.
 */
public class BaseballGame {
    private final BaseballNumbers targetNumber;
    private final View view;
    private final Supplier<String> readLineFn;
    private final int numberOfTargetNumber;

    public BaseballGame(int numberOfTargetNumber, RandomNumberGenerator randomNumberGenerator, View view, Supplier<String> readLineFn) {
        this.numberOfTargetNumber = numberOfTargetNumber;
        this.targetNumber = new BaseballNumbers(randomNumberGenerator.generate());
        this.view = view;
        this.readLineFn = readLineFn;
    }

    private BaseballNumbers readAttempt() {
        view.askToPutNumber();
        final String strAttemptNumbers = readLineFn.get();
        if (strAttemptNumbers.length() != numberOfTargetNumber) {
            throw new IllegalArgumentException();
        }
        return new BaseballNumbers(strAttemptNumbers);
    }

    public void play() {
        Score score;
        do {
            score = targetNumber.matchScore(readAttempt());
            view.score(score);
        } while (!score.isWinTheGame());

        view.winTheGame();
        return;
    }
}
