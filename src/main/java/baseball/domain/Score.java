package baseball.domain;


import static baseball.constant.GameConfig.*;

public class Score {

    private int strike;
    private int ball;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void countStrike() {
        this.strike++;
    }

    public void countBall() {
        this.ball++;
    }

    public boolean isWin() {
        return this.strike == ANSWER_SIZE;
    }

    public boolean isNothing() {
        return this.strike == 0 && this.ball == 0;
    }

    public String getScoreMessage() {
        if (isNothing()) {
            return NOTHING_STR;
        }
        if (this.ball > 0 && this.strike == 0) {
            return String.format(BALL_STR, this.ball);
        }
        if (this.ball == 0 && this.strike > 0) {
            return String.format(STRIKE_STR, this.strike);
        }

        return String.format(BALL_STRIKE_STR, ball, strike);

    }

    public void initScore() {
        this.strike = 0;
        this.ball = 0;
    }
}
