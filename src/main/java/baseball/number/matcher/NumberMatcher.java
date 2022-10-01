package baseball.number.matcher;

import baseball.number.InputNumbers;
import baseball.number.TargetNumbers;
import baseball.score.Score;
import baseball.score.Scores;

import java.util.List;
import java.util.Map;

public class NumberMatcher {

    private final TargetNumbers targetNumbers;
    private final InputNumbers inputNumbers;

    public NumberMatcher(TargetNumbers targetNumbers, InputNumbers inputNumbers) {
        this.targetNumbers = targetNumbers;
        this.inputNumbers = inputNumbers;
    }

    public Map<Score, Integer> matchedResult() {
        List<Score> matchedScore = match();
        Scores scores = new Scores(matchedScore);
        return scores.getScoreIntegerMap();
    }

    List<Score> match() {
        return inputNumbers.match(targetNumbers);
    }
}
