package baseball;

public class Ball {
    private int location;
    private int ballNumber;

    public Ball(int location, int ballNumber) {
        this.location = location;
        this.ballNumber = ballNumber;
    }

    public MATCH_RESULT match(Ball counterBall) {
        if (!this.isEqualBallNumber(counterBall)) {
            return MATCH_RESULT.NOTHING;
        }

        if (!this.isEqualLocation(counterBall)) {
            return MATCH_RESULT.BALL;
        }

        return MATCH_RESULT.STRIKE;
    }

    private boolean isEqualBallNumber(Ball counterBall) {
        return this.ballNumber == counterBall.getBallNumber();
    }

    private boolean isEqualLocation(Ball counterBall) {
        return this.location == counterBall.getLocation();
    }

    private int getBallNumber() {
        return this.ballNumber;
    }

    private int getLocation() {
        return this.location;
    }
}
