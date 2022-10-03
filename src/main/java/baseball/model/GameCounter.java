package baseball.model;

import java.util.List;

public class GameCounter {

    private int strike;
    private int ball;
    private List<Integer> randomList;

    public GameCounter() {
        strike = ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean hasBall() {
        return ball > 0;
    }

    public boolean hasStrike() {
        return strike > 0;
    }

    public void calculate(List<Integer> userList, List<Integer> randomList) {
        this.randomList = randomList;

        for (int userPosition = 0; userPosition < userList.size(); userPosition++) {
            countBall(userList.get(userPosition), userPosition);
            countStrike(userList.get(userPosition), userPosition);
        }
    }

    private void countBall(Integer userNumber, int userPosition) {
        for (int randomPosition = 0; randomPosition < randomList.size(); randomPosition++) {
            checkBall(userNumber, userPosition, randomPosition);
        }
    }

    private void checkBall(Integer userNumber, int userPosition, int randomPosition) {
        if (userPosition == randomPosition) {
            return;
        }

        if (userNumber.equals(randomList.get(randomPosition))) {
            ball++;
        }
    }

    private void countStrike(Integer userNumber, int position) {
        if (userNumber.equals(randomList.get(position))) {
            strike++;
        }
    }
}