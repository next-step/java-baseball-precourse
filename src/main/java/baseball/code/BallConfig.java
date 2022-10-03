package baseball.code;

public enum BallConfig {
    BALL_LIST_SIZE(3),
    BALL_RANGE_START(1),
    BALL_RANGE_END(9);

    private final int ballConfig;

    BallConfig(int ballConfig) {
        this.ballConfig = ballConfig;
    }

    public int getBallConfig() {
        return this.ballConfig;
    }

}
