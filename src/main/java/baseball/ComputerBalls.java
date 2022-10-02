package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerBalls {

    private String balls;

    public ComputerBalls() {

    }

    public String getBalls() {
        return balls;
    }

    public void setBalls() {
        balls = makeBalls();
    }

    private String makeBalls() {
        StringBuilder stringBalls = new StringBuilder();
        while (stringBalls.length() < GameConstants.numberOfBalls) {
            pickNumber(stringBalls);
        }

        return stringBalls.toString();
    }

    private void pickNumber(StringBuilder stringBalls) {
        String candidate = Integer.toString(Randoms.pickNumberInRange(1,9));
        if(!stringBalls.toString().contains(candidate)) {
            stringBalls.append(candidate);
        }
    }

}
