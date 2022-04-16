package baseball.game;

import java.util.HashMap;
import java.util.Map;

public class RoundScore {
    private final Map<Judgment, Integer> m = new HashMap<>();

    public RoundScore() { }

    private int getNumberOf(Judgment judgment) {
        if (!m.containsKey(judgment)) {
            return 0;
        }
        return m.get(judgment);
    }

    public int getNumStrikes() {
        return getNumberOf(Judgment.STRIKE);
    }

    public int getNumBalls() {
        return getNumberOf(Judgment.BALL);
    }

    public void addJudgment(Judgment judgment) {
        if (!m.containsKey(judgment)) {
            m.put(judgment, 1);
            return;
        }
        m.put(judgment, m.get(judgment) + 1);
    }
}
