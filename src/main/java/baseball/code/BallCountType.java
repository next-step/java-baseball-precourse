package baseball.code;

public enum BallCountType {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String ballCountType;

    BallCountType(String ballCountType) {
        this.ballCountType = ballCountType;
    }

    public String getBallCount() {
        return this.ballCountType;
    }
}
