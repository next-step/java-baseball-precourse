package baseball.game;

import java.util.HashMap;
import java.util.Map;

public class RoundScore {
    private final Map<Judgment, Integer> m = new HashMap<>();

    public RoundScore() {
        m.put(Judgment.STRIKE, 0);
        m.put(Judgment.BALL, 0);
        m.put(Judgment.NONE, 0);
    }

    private int getNumberOf(Judgment judgment) {
        return m.get(judgment);
    }

    public int getNumStrikes() {
        return getNumberOf(Judgment.STRIKE);
    }

    public int getNumBalls() {
        return getNumberOf(Judgment.BALL);
    }

    public void addJudgment(Judgment judgment) {
        m.put(judgment, m.get(judgment) + 1);
    }
}
