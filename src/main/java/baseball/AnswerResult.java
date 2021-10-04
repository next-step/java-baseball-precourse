package baseball;

import java.util.Objects;

public class AnswerResult {


    private static final int FINISH_STRIKE_COUNT = 3;

    private int ballCount;

    private int strikeCount;


    public AnswerResult() {
    }

    public AnswerResult(int strikeCount, int ballCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerResult that = (AnswerResult) o;
        return ballCount == that.ballCount && strikeCount == that.strikeCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballCount, strikeCount);
    }
}
