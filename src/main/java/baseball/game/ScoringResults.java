package baseball.game;

import java.util.HashMap;
import java.util.Map;

public class ScoringResults {
    private final Map<GuessingJudgment, Integer> m = new HashMap<>();

    public ScoringResults() {
        m.put(GuessingJudgment.STRIKE, 0);
        m.put(GuessingJudgment.BALL, 0);
        m.put(GuessingJudgment.NONE, 0);
    }

    private int getNumberOf(GuessingJudgment guessingJudgment) {
        return m.get(guessingJudgment);
    }

    public int getNumStrikes() {
        return getNumberOf(GuessingJudgment.STRIKE);
    }

    public int getNumBalls() {
        return getNumberOf(GuessingJudgment.BALL);
    }

    public void addJudgment(GuessingJudgment guessingJudgment) {
        m.put(guessingJudgment, m.get(guessingJudgment) + 1);
    }
}
