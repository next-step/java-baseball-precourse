package baseball.model;

import java.util.List;

public class GameStatus {
    private int strike;
    private int ball;

    public GameStatus(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public GameStatus() {
        this.strike = 0;
        this.ball = 0;
    }

    public GameStatus isGameStatus(Numbers numbers) {
        for (int i=0; i<numbers.getGenerateComputeNumber().size(); i++) {
            isCompare(numbers, i, numbers.getGenerateComputeNumber().get(i));
        }
        return new GameStatus(this.strike, this.ball);
    }

    private boolean isNothing() {
        return this.strike == 0 && this.ball == 0;
    }

    private void isCompare(Numbers numbers, int i, Integer value) {
        if (isStrike(numbers.getUserInputNumber(), i, value)) {
            isBall(numbers.getUserInputNumber(), value);
        }
    }

    private boolean isStrike(List<Integer> userNumber, int i, Integer value) {
        if (userNumber.get(i) == value) {
            strike++;
            return false;
        }
        return true;
    }

    private void isBall(List<Integer> userNumber, int value) {
        if (userNumber.contains(value)) {
            ball++;
        }
    }

    public String getResult() {
        StringBuilder sb = new StringBuilder();
        if (isNothing()) {
            sb.append("낫싱");
        }

        if (this.strike != 0) {
            sb.append(this.strike + "스트라이크 ");
        }

        if (this.ball != 0) {
            sb.append(this.ball + "볼");
        }
        return sb.toString();
    }

    public boolean isWin() {
        return this.strike == 3;
    }

}
