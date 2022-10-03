package baseball.domain;

public class GameResult {

    private static final int OUT_STRIKE_COUNT = 3;
    private int ballCount;
    private int strikeCount;

    public GameResult() {
        ballCount = 0;
        strikeCount = 0;
    }

    public void report(BallStatus ballStatus) {
        strikeReport(ballStatus);
        ballReport(ballStatus);
    }

    public boolean isOut() {
        return strikeCount == OUT_STRIKE_COUNT;
    }

    private void ballReport(BallStatus ballStatus) {
        if (ballStatus.isBall()) {
            ballCount++;
        }
    }

    private void strikeReport(BallStatus ballStatus) {
        if (ballStatus.isStrike()) {
            strikeCount++;
        }
    }

    private String strikeCountString() {
        if (strikeCount != 0) {
            return strikeCount + "스트라이크";
        }
        return "";
    }

    private String ballCountString() {
        if (ballCount != 0) {
            return ballCount + "볼 ";
        }
        return "";
    }

    @Override
    public String toString() {
        String result = "";
        if (ballCount == 0 && strikeCount == 0) {
            return "낫싱";
        }
        result += ballCountString();
        result += strikeCountString();
        return result;
    }
}
