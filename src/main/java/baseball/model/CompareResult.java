package baseball.model;

import baseball.model.enums.BallStatus;

public class CompareResult {
    private static final int ZERO = 0;
    private static final String SPACE = " ";

    private final int maxSize;
    private int strikeCount;
    private int ballCount;

    public CompareResult(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void increaseCountByStatus(BallStatus status) {
        if (status.isStrike()) {
            strikeCount++;
        }

        if (status.isBall()) {
            ballCount++;
        }
    }

    public boolean isStrike() {
        return strikeCount == maxSize;
    }

    public String convertMessage() {
        if (hasStrikeCount() && hasBallCount()) {
            return strikeMessage() + SPACE + ballMessage();
        }

        return convertOneMessage();
    }

    private String convertOneMessage() {
        if (hasStrikeCount()) {
            return strikeMessage();
        }

        if (hasBallCount()) {
            return ballMessage();
        }

        return BallStatus.NONE.message();
    }

    private boolean hasStrikeCount() {
        return strikeCount > ZERO;
    }

    private boolean hasBallCount() {
        return ballCount > ZERO;
    }

    private String strikeMessage() {
        return strikeCount + BallStatus.STRIKE.message();
    }

    private String ballMessage() {
        return ballCount + BallStatus.BALL.message();
    }
}
