package baseball.domain;

import baseball.view.BaseballPrint;

public class PlayResult {

    private static final int ZERO = 0;
    private static final int END_GAME = 3;
    public static final String BLANK = "";

    private int strike = ZERO;
    private int ball = ZERO;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void increaseCount(BallStatus status) {
        if (status == BallStatus.STRIKE) {
            strike ++;
        }

        if (status == BallStatus.BALL) {
            ball ++;
        }
    }

    public boolean isEndGame() {
        if (strike == END_GAME) {
            BaseballPrint.println(Message.END_GAME.getMessage());
            return true;
        }

        return false;
    }

    public String resultMessage() {
        if (ball == ZERO && strike == ZERO) {
            return BallStatus.NOTHING.getStatus();
        }

        return mergeMessage(getZeroStrike(), getZeroBall());
    }

    private String getZeroBall() {
        if (ball == ZERO) {
            return BLANK;
        }

        return mergeMessage(ball, BallStatus.BALL.getStatus());
    }

    private String getZeroStrike() {
        if (strike == ZERO) {
            return BLANK;
        }

        return mergeMessage(strike, BallStatus.STRIKE.getStatus());
    }

    private String mergeMessage(Object count, String message) {
        return count + message;
    }
}
