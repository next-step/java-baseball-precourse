package baseball;

import baseball.number.InputNumbers;
import baseball.number.TargetNumbers;
import baseball.number.matcher.NumberMatcher;
import baseball.number.strategy.ExtractRandomNumberByPickNumber;
import baseball.score.Score;
import baseball.view.InputView;
import baseball.view.ResultView;

import java.util.Map;

public class Application {
    private static final int COUNT_OF_ALL = 3;
    private static final String RETRY_NUMBER = "1";

    public static void main(String[] args) {
        game();
    }

    private static void game() {
        TargetNumbers targetNumbers = new TargetNumbers(new ExtractRandomNumberByPickNumber());
        while (true) {
            InputNumbers inputNumbers = new InputNumbers(InputView.inputNumber());
            if (terminable(matchedResult(targetNumbers, inputNumbers))) {
                return;
            }
        }
    }

    private static Map<Score, Integer> matchedResult(TargetNumbers targetNumbers, InputNumbers inputNumbers) {
        NumberMatcher numberMatcher = new NumberMatcher(targetNumbers, inputNumbers);
        Map<Score, Integer> scoreIntegerMap = numberMatcher.matchedResult();
        ResultView.printResult(scoreIntegerMap);
        return scoreIntegerMap;
    }

    private static boolean terminable(Map<Score, Integer> scoreIntegerMap) {
        if (scoreIntegerMap.get(Score.STRIKE) == COUNT_OF_ALL) {
            ResultView.printDone();
            return retryable(InputView.retry());
        }
        return false;
    }

    private static boolean retryable(String retry) {
        if (retry.equals(RETRY_NUMBER)) {
            game();
        }
        return true;
    }
}
