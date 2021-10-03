package baseball;

public class AnswerResult {

    private int ballCount;

    public int strikeCount;

    public void addBallCount() {
        ballCount++;
    }

    public void addStrikeCount() {
        strikeCount++;
    }

    public boolean isCorrectAnswer() {
        return strikeCount == 3;
    }

    @Override
    public String toString() {
        return "스트라이크" + strikeCount +
                " 볼" + ballCount;
    }
}
