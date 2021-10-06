package baseball;

import java.util.StringJoiner;

public class Result {
    private final static int CORRECT_STRIKE_COUNT = 3;
    private final static String BLACK_SPACE = " ";
    private final int strikeCount;
    private final int ballCount;

    public Result(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public String getMessage() {
        if (isNothing()) return "낫싱";

        StringJoiner stringJoiner = new StringJoiner(BLACK_SPACE);
        if (strikeCount > 0) stringJoiner.add(String.format("%d스트라이크", strikeCount));
        if (ballCount > 0) stringJoiner.add(String.format("%d볼", ballCount));
        if (isCorrect()) stringJoiner.add("\n3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        return stringJoiner.toString();
    }

    public boolean isCorrect() {
        return this.strikeCount == CORRECT_STRIKE_COUNT;
    }

    private boolean isNothing() {
        return this.strikeCount == 0 && this.ballCount == 0;
    }
}
