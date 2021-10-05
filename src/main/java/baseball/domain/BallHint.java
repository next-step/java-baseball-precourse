package baseball.domain;

public enum BallHint {

    STRIKE, BALL, NOTHING;

    boolean isStrike() {
        return this.equals(STRIKE);
    }

    boolean isBall() {
        return this.equals(BALL);
    }

    boolean isNothing() {
        return this.equals(NOTHING);
    }


}
