package baseball.domain;

import java.util.Objects;

public class Score {
    private int ball;
    private int strike;

    Score(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public Score addStrike() {
        return new Score(this.ball, this.strike + 1);
    }

    public Score addBall() {
        return new Score(this.ball + 1, this.strike);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return ball == score.ball && strike == score.strike;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball, strike);
    }

    @Override
    public String toString() {
        return "Score{" +
                "ball=" + ball +
                ", strike=" + strike +
                '}';
    }

    public String yield() {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }
        if (strike == 0) {
            return ball + "볼";
        }
        if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }

    public boolean isDone() {
        if (this.strike == 3) {
            return true;
        }
        return false;
    }
}
