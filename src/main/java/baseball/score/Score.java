package baseball.score;

import java.util.EnumMap;
import java.util.Map;

public enum Score {
    STRIKE,
    BALL,
    NOTHING;

    private static final int INITIAL_VALUE = 0;

    public static Map<Score, Integer> scoreMap() {
        Map<Score, Integer> scoreIntegerMap = new EnumMap<>(Score.class);
        for (Score score : values()) {
            scoreIntegerMap.put(score, INITIAL_VALUE);
        }
        return scoreIntegerMap;
    }
}
