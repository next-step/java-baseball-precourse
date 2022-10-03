package baseball.domain;

import static baseball.domain.BallStatus.BALL;
import static baseball.domain.BallStatus.NOTHING;
import static baseball.domain.BallStatus.STRIKE;

public class Ball {

    private final Number number;
    private final Location location;

    public Ball(int number, int location) {
        this.number = Number.from(number);
        this.location = Location.from(location);
    }

    public BallStatus judgeBall(Ball ball) {
        if (isSameLocation(ball) && isSameNumber(ball)) {
            return STRIKE;
        }

        if (isSameNumber(ball)) {
            return BALL;
        }

        return NOTHING;
    }

    private boolean isSameNumber(Ball ball) {
        return this.number == ball.number;
    }

    private boolean isSameLocation(Ball ball) {
        return this.location == ball.location;
    }

}
