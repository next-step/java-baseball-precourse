package baseball.model;

public enum JudgeResult {
    STRIKE,
    BALL,
    NONE;

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }
}
