package baseball.score;

import baseball.common.ScoreType;

import java.util.ArrayList;
import java.util.List;

import static baseball.common.Constant.*;

public class BaseBallScore extends Score {
    int strike;
    int ball;

    public BaseBallScore() {
        this.strike = ZERO_VALUE;
        this.ball = ZERO_VALUE;
    }

    public void addStrike() {
        strike += ONE_VALUE;
    }

    public void addBall() {
        ball += ONE_VALUE;
    }

    public int getStrike() {
        return strike;
    }

    public boolean isNothing() {
        return strike == ZERO_VALUE && ball == ZERO_VALUE;
    }

    public int getBall() {
        return ball;
    }

    private List<String> getScores() {
        List<String> scores = new ArrayList<>();
        if (isNothing()) {
            scores.add(ScoreType.NOTHING.getDescription(ZERO_VALUE));
        }
        if (getStrike() != 0) {
            scores.add(ScoreType.STRIKE.getDescription(this.strike));
        }
        if (getBall() != 0) {
            scores.add(ScoreType.BALL.getDescription(this.ball));
        }
        return scores;
    }

    @Override
    public String toString() {
        List<String> scores = getScores();
        String description = EMPTY;
        for (String score : scores) {
            description += score;
            if (scores.indexOf(score) < scores.size() - 1)
                description += BLANK;
        }
        return description;
    }
}
