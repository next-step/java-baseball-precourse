package baseball.domain.score;

import static baseball.domain.score.ScoreType.*;

public class Score {
    private int strike;
    private int ball;

    public Score() {
        strike = 0;
        ball = 0;
    }

    public void put(ScoreType scoreType) {
        if (scoreType == STRIKE) {
            addStrike();
        }
        if (scoreType == BALL) {
            addBall();
        }
    }

    public String getScoreString() {
        StringBuilder sb = new StringBuilder();
        if (hasStrike()) {
            sb.append(strike + STRIKE.getName() + " ");
        }
        if (hasBall()) {
            sb.append(ball + BALL.getName() + " ");
        }
        if (isNothing()) {
            sb.append(NOTHING.getName());
        }
        return sb.toString();
    }

    private void addStrike() {
        strike++;
    }

    private void addBall() {
        ball++;
    }

    private boolean hasStrike() {
        return strike > 0;
    }

    private boolean hasBall() {
        return ball > 0;
    }

    private boolean isNothing() {
        return !(hasStrike() && hasBall());
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}