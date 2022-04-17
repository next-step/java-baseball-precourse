package baseball;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BaseballGame Score.
 * - `inWinTheGame` 승리여부를 알 수 있습니다.
 * - `getScoreMap` : 각 {@link ScoreEnum} 의 개수를 집계하여 리턴합니다.
 */
public class Score {
    private final HashMap<ScoreEnum, Integer> scoreMap;
    private final int winCount;

    public Score(List<ScoreEnum> scoreEnums, int winCount) {
        this.scoreMap = new HashMap<>();
        for (ScoreEnum scoreEnum : scoreEnums) {
            this.scoreMap.put(scoreEnum, this.scoreMap.getOrDefault(scoreEnum, 0) + 1);
        }
        this.winCount = winCount;
    }

    public Map<ScoreEnum, Integer> scoreMap() {
        return Collections.unmodifiableMap(scoreMap);
    }

    /**
     * 게임을 이긴 경우 true 를 리턴합니다.
     */
    public boolean isWinTheGame() {
        return scoreMap.getOrDefault(ScoreEnum.STRIKE, -1) == this.winCount;
    }

    /**
     * 모든 숫자가 맞지 않는 경우 true를 리턴합니다.
     */
    public boolean isAllNothing() {
        return scoreMap.getOrDefault(ScoreEnum.NOTHING,-1) == this.winCount;
    }

    /**
     * Score 종류.
     */
    public enum ScoreEnum {
        STRIKE("스트라이크"), BALL("볼"), NOTHING("낫싱");

        private final String name;

        ScoreEnum(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    @Override
    public String toString() {
        return "Score{" +
                "scoreMap=" + scoreMap +
                '}';
    }
}
