package baseball.model;

import java.util.List;

public class GameStatus {
    private int strike = 0;
    private int ball = 0;

    public GameStatus(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public GameStatus isGameStatus(List<Integer> baseballNumber, List<Integer> inputNumber) {
        for (int i=0; i<baseballNumber.size(); i++) {
            compare(baseballNumber, inputNumber, i, baseballNumber.get(i));
        }

        return new GameStatus(this.strike, this.ball);
    }

    private void compare(List<Integer> baseballNumber, List<Integer> inputNumber, int i, int value) {
        if (isStrike(inputNumber, i, value)) {
            isBall(baseballNumber.get(i), inputNumber);
        }
    }

    private void isBall(int value, List<Integer> inputNumber) {
        if (inputNumber.contains(value)) {
            ball++;
        }
    }

    private boolean isStrike(List<Integer> inputNumber, int i, int value) {
        if (inputNumber.get(i) == value) {
            strike++;
            return false;
        }
        return true;
    }


}
