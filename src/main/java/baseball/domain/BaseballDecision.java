package baseball.domain;

public class BaseballDecision {
    private final BaseballNumber computerNumber;

    public BaseballDecision(BaseballNumber computerNumber) {
        this.computerNumber = computerNumber;
    }

    public BaseballResult getResult(BaseballNumber userNumber) {
        int strike = getStrikeCount(userNumber);
        int ball = getBallCount(userNumber);

        return new BaseballResult(strike, ball);
    }

    private int getStrikeCount(BaseballNumber userNumber) {
        int strike = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            if (userNumber.get(i).compareTo(computerNumber.get(i)) == 0) {
                strike++;
            }
        }

        return strike;
    }

    private int getBallCount(BaseballNumber userNumber) {
        int ball = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            Integer input = userNumber.get(i);
            if (input.compareTo(computerNumber.get(i)) != 0 && computerNumber.contains(input)) {
                ball++;
            }
        }

        return ball;
    }
}
