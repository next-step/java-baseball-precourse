package baseball.domain;

import java.util.List;

public class BallCount {
    private int strike;
    private int ball;

    public void judgeNumbers(List<Integer> inputNumbers, Ball resultNumber) {
        Integer position = 0;
        for (Integer number : inputNumbers) {
            position++;
            increaseBallCount(resultNumber.play(new Ball(position, number)));
        }
    }

    private void increaseBallCount(BallStatus ballStatus) {
        if (ballStatus == BallStatus.STRIKE) {
            strike++;
            return;
        }
        if (ballStatus == BallStatus.BALL) {
            ball++;
        }
    }

    public boolean isFinish() {
        return strike == 3;
    }

    @Override
    public String toString() {
        String result = "";
        if (ball > 0) result += String.format("%d볼", ball);
        if (ball * strike != 0) result += " ";
        if (strike > 0) result += String.format("%d스트라이크", strike);
        if (result.length() == 0) result = "낫싱";
        return result;
    }
}
