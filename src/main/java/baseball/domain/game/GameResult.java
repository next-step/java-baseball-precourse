package baseball.domain.game;

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
        for (int index = 0; index < computerNumbers.size(); index++) {
            strike += getStrikeCnt(index);
            ball += getBallCnt(index);
        }
    }

    private int getStrikeCnt(int index) {
        if (computerNumbers.get(index).equals(userNumbers.get(index))) {
            return 1;
        }
        return 0;
    }

    private int getBallCnt(int index) {
        if (computerNumbers.contains(userNumbers.get(index)) && getStrikeCnt(index) == 0) {
            return 1;
        }
        return 0;
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
