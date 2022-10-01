package baseball.score;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Scores {
    private static final int ELEVATION_INTERVAL = 1;

    private Map<Score, Integer> scoreIntegerMap;

    public Scores(List<Score> scoreList) {
        initial(scoreList);
    }

    public Scores(Map<Score, Integer> scoreIntegerMap) {
        this.scoreIntegerMap = scoreIntegerMap;
    }

    private void initial(List<Score> scoreList) {
        scoreIntegerMap = Score.scoreMap();
        for (Score score : scoreList) {
            scoreIntegerMap.merge(score, ELEVATION_INTERVAL, Integer::sum);
        }
    }

    public Map<Score, Integer> getScoreIntegerMap() {
        return Collections.unmodifiableMap(scoreIntegerMap);
    }
}
