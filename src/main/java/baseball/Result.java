package baseball;

import java.util.StringJoiner;

public class Result {
    private final static int CORRECT_STRIKE_COUNT = 3;
    private final static String BLACK_SPACE = " ";
    private final int strike;
    private final int ball;

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public String getMessage() {
        if (isNothing()) return "낫싱";

        StringJoiner stringJoiner = new StringJoiner(BLACK_SPACE);
        if (strike > 0) stringJoiner.add(String.format("%d스트라이크", strike));
        if (ball > 0) stringJoiner.add(String.format("%d볼", ball));
        if (isCorrect()) stringJoiner.add("\n3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        return stringJoiner.toString();
    }

    public boolean isCorrect() {
        return this.strike == CORRECT_STRIKE_COUNT;
    }

    private boolean isNothing() {
        return this.strike == 0 && this.ball == 0;
    }
}
