package baseball.model;

import baseball.model.enums.BallStatus;

public class CompareResult {
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
}
