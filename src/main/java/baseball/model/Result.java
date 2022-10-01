package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private final int ball;
    private final int strike;

    private Result(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public static Result nothing() {
        return new Result(0, 0);
    }

    public static Result ball() {
        return new Result(1, 0);
    }

    public static Result strike() {
        return new Result(0, 1);
    }

    public boolean isFinish() {
        return strike == 3;
    }

    public Result add(final Result result) {
        return new Result(this.ball + result.ball, this.strike + result.strike);
    }

    public String getResult() {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }

        List<String> results = new ArrayList<>(2);

        if (ball > 0) {
            results.add(String.format("%s볼", this.ball));
        }

        if (strike > 0) {
            results.add(String.format("%s스트라이크", this.strike));
        }

        return String.join(" ", results);
    }
}
