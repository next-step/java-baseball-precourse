package baseball.domain;

import java.util.List;

public class GameResult {
    private final List<Integer> computerNumbers;
    private final List<Integer> userNumbers;
    private int ball;
    private int strike;

    public GameResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
        this.computerNumbers = computerNumbers;
        this.userNumbers = userNumbers;
        this.ball = 0;
        this.strike = 0;
        calGameResult();
    }

    private void calGameResult() {
        for (int i = 0; i < computerNumbers.size(); i++) {
            if (isStrike(i)) {
                strike++;
                continue;
            }

            if (isBall(i)) {
                ball++;
            }
        }
    }

    private boolean isStrike(int index) {
        return computerNumbers.get(index).equals(userNumbers.get(index));
    }

    private boolean isBall(int index) {
        return computerNumbers.contains(userNumbers.get(index));
    }

    public boolean isNothing() {
        return ball + strike == 0;
    }

    public boolean isWinning() {
        return strike == userNumbers.size();
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
}
