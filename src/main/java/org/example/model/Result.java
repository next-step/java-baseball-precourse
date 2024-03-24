package org.example.model;

public class Result {

    private int strike;

    private int ball;

    public void strike() {
        strike++;
    }

    public void ball() {
        ball++;
    }

    public int getStrike() {
        return strike;
    }

    public void clear() {
        strike = 0;
        ball = 0;
    }

    public String toString() {
        if (strike == 0 && ball == 0) {
            return Hint.NOTHING.getValue();
        }

        StringBuilder sb = new StringBuilder();
        if (strike > 0) {
            sb.append(strike).append(Hint.STRIKE.getValue()).append(" ");
        }

        if (ball > 0) {
            sb.append(ball).append(Hint.BALL.getValue());
        }

        return sb.toString();
    }
}
