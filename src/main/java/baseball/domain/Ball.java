package baseball.domain;

import java.util.Objects;

import static baseball.common.Constants.BALL_MAX;
import static baseball.common.Constants.BALL_MIN;

public class Ball {

    private int pos;
    private int number;

    public Ball() {

    }

    public Ball(int pos, int number) {
        this.pos = pos;
        this.number = number;
    }



    public BallStatus compareBall(Ball targetBall) {
        if (this.equals(targetBall)) {
            return BallStatus.STRIKE;
        }

        if (checkNumber(targetBall.number)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    public boolean checkNumber(int targetNo) {
        if (targetNo == this.number) {
            return true;
        }
        return false;
    }

    public static boolean isBetween1And(int num) {
        if (BALL_MIN <= num && num <= BALL_MAX) {
            return true;
        } else {
            return false;
        }

    }

    public int getPos() {
        return pos;
    }

    public int getNumber() {
        return number;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Ball))
            return false;

        Ball targetBall = (Ball) o;

        return targetBall.pos == this.pos && targetBall.number == this.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pos, number);
    }


}

