package baseball.vo;

public class GameResultStatus {

    private boolean gameResult;
    private int ballCount = 0;
    private int strikeCount = 0;

    public boolean isSameNumber() {
        return gameResult;
    }

    public void checkBaseballGameResult() {
        if (strikeCount == 3) {
            gameResult = true;
            return;
        }
        gameResult = false;
    }

    public void addBallCount() {
        this.ballCount++;
    }

    public void minusBallCount() {
        this.ballCount--;
    }

    public void plusStrikeCount() {
        this.strikeCount++;
    }

    public String generateBallComment(String ball) {
        if (ballCount == 0) {
            return null;
        }
        return new StringBuilder()
                .append(ballCount)
                .append(ball).append(" ").toString();
    }

    public String generateStrikeComment(String strike) {
        if (strikeCount == 0) {
            return null;
        }
        return new StringBuilder()
                .append(strikeCount)
                .append(strike).toString();
    }
}
