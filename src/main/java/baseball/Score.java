package baseball;

import java.util.Objects;

public class Score {
    private int ball;
    private int strike;

    public Score() {
        this.ball = 0;
        this.strike = 0;
    }

    public Score(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    private String getBallString() {
        if (this.ball > 0) {
            return (this.ball + "볼 ");
        }
        return "";
    }

    private String getStrikeString() {
        if (this.strike > 0) {
            return (this.strike + "스트라이크");
        }
        return "";
    }

    @Override
    public String toString() {
        String result = "";
        if (this.ball == 0 && this.strike == 0) {
            return "낫싱";
        }
        result += getBallString();
        result += getStrikeString();
        return result.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Score score = (Score) o;
        return ball == score.ball && strike == score.strike;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball, strike);
    }

    private void increaseBall() {
        this.ball++;
    }

    private void increaseStrike() {
        this.strike++;
    }

    public void countBall(String answer, String number, int position) {
        if (answer.charAt(position) == number.charAt(position)) {
            return;
        }
        if (answer.contains(Character.toString(number.charAt(position)))) {
            increaseBall();
        }
    }

    public void countStrike(String answer, String number, int position) {
        if (answer.charAt(position) == number.charAt(position)) {
            increaseStrike();
        }
    }
}
