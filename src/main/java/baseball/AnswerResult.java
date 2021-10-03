package baseball;

public class AnswerResult {

    private static final int FINISH_STRIKE_COUNT = 3;

    private int ballCount;

    public int strikeCount;

    public void addBallCount() {
        ballCount++;
    }

    public void addStrikeCount() {
        strikeCount++;
    }

    public boolean isCorrectAnswer() {
        return strikeCount == FINISH_STRIKE_COUNT;
    }

    @Override
    public String toString() {
        if (ballCount == 0 && strikeCount == 0) {
            return "낫싱";
        }
        if (ballCount == 0 && strikeCount != 0) {
            return strikeCount + "스트라이크";
        }
        if (ballCount != 0 && strikeCount == 0) {
            return ballCount + "볼";
        }
        return strikeCount + "스트라이크 " + ballCount + "볼";
    }
}
