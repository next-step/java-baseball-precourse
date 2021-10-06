package baseball.ball;

import java.util.*;

/**
 * @author KingCjy
 */
public class BallCount {

    private static final int FINISH_STRIKE_COUNT = 3;

    private final Map<Score, Integer> scores = new HashMap<>();

    public static BallCount NOTHING = new BallCount(Arrays.asList(Score.NOTHING, Score.NOTHING, Score.NOTHING));

    public BallCount(List<Score> scores) {
        for (Score score : scores) {
            int count = this.scores.getOrDefault(score, 0) + 1;
            this.scores.put(score, count);
        }
    }

    public boolean isFinish() {
        return countByScore(Score.STRIKE) == FINISH_STRIKE_COUNT;
    }

    public String getMessage() {
        String message = (getMessageByScore(Score.STRIKE) + getMessageByScore(Score.BALL)).trim();

        if ("".equals(message)) {
            return Score.NOTHING.getDisplayName();
        }

        return message;
    }

    private String getMessageByScore(Score score) {
        if (scores.get(score) == null) {
            return "";
        }

        return " " + scores.get(score) + score.getDisplayName();
    }

    private int countByScore(Score score) {
        return scores.getOrDefault(score, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallCount ballCount = (BallCount) o;
        return Objects.equals(scores, ballCount.scores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scores);
    }

    @Override
    public String toString() {
        return "BallCount{" +
                "scores=" + scores +
                '}';
    }

}
