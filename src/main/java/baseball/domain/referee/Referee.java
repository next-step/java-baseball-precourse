package baseball.domain.referee;

import baseball.contant.BaseballConstant;
import baseball.domain.number.BaseballNumber;
import baseball.domain.number.BaseballNumbers;

public class Referee {
    private Hint hint;

    private Referee() {
        this.hint = Hint.of(0, 0);
    }

    public static Referee create() {
        return new Referee();
    }

    public void judge(BaseballNumbers computerNumbers, BaseballNumbers userNumbers) {
        this.hint.updateStrikeCount(strike(computerNumbers, userNumbers));
        this.hint.updateBallCount(ball(computerNumbers, userNumbers));
    }

    private int strike(BaseballNumbers computerNumbers, BaseballNumbers userNumbers) {
        int strike = 0;
        for (int i = 0; i < BaseballConstant.BASEBALL_NUMBERS_SIZE; i++) {
            BaseballNumber computerNumber = computerNumbers.getBaseBallNumberByIndex(i);
            BaseballNumber userNumber = userNumbers.getBaseBallNumberByIndex(i);
            strike += judgeStrike(computerNumber, userNumber);
        }
        return strike;
    }

    private int judgeStrike(BaseballNumber computerNumber, BaseballNumber userNumber) {
        if (computerNumber.equals(userNumber)) {
            return 1;
        }
        return 0;
    }

    private int ball(BaseballNumbers computerNumbers, BaseballNumbers userNumbers) {
        int ball = 0;
        for (int i = 0; i < BaseballConstant.BASEBALL_NUMBERS_SIZE; i++) {
            BaseballNumber computerNumber = computerNumbers.getBaseBallNumberByIndex(i);
            BaseballNumber userNumber = userNumbers.getBaseBallNumberByIndex(i);
            ball += judgeBall(computerNumbers, computerNumber, userNumber);
        }
        return ball;
    }

    private int judgeBall(BaseballNumbers computerNumbers, BaseballNumber computerNumber, BaseballNumber userNumber) {
        if (computerNumbers.contains(userNumber) && !computerNumber.equals(userNumber)) {
            return 1;
        }
        return 0;
    }

    public Hint getHint() {
        return hint;
    }

    public boolean onPlay() {
        return this.hint.getStrike() != BaseballConstant.BASEBALL_END_STRIKE_COUNT;
    }
}
