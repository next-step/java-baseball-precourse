package baseball.answer;
import static baseball.answer.AnswerErrorEnum.*;

public class Answer {
    private int strike = 0;
    private int ball = 0;
    private static final int MAX_COUNT = 3;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void addStrike() {
        isSumOverMaxCount();
        this.strike++;
    }

    public void addBall() {
        isSumOverMaxCount();
        this.ball++;
    }

    private void isSumOverMaxCount() {
        if(this.strike + this.ball >= MAX_COUNT)
            throw new IllegalArgumentException(SUM_OVER_THREE.text());
    }
}
