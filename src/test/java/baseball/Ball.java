package baseball;

public class Ball {
    public static final int MIN_BALL_NUMBER = 1;
    public static final int MAX_BALL_NUMBER = 9;

    private int ballNumber;
    private int location;

    public Ball(int ballNumber, int location) {
        if (ballNumber < MIN_BALL_NUMBER || ballNumber > MAX_BALL_NUMBER) {
            throw new IllegalArgumentException("공의 번호는 " + MIN_BALL_NUMBER + "과 " + MAX_BALL_NUMBER + " 범위 내의 정수값이어야 합니다.");
        }

        this.ballNumber = ballNumber;
        this.location = location;
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
