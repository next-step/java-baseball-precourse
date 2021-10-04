package baseball;

public class Ball {
    public static final String INVALID_BALL_NUMBER_MSG = "공의 번호는 " + GlobalVariables.MIN_BALL_NUMBER + "과 " + GlobalVariables.MAX_BALL_NUMBER + " 범위 내의 정수값이어야 합니다.";

    private int ballNumber;
    private int location;

    public Ball(int ballNumber, int location) {
        if (ballNumber < GlobalVariables.MIN_BALL_NUMBER || ballNumber > GlobalVariables.MAX_BALL_NUMBER) {
            throw new IllegalArgumentException(INVALID_BALL_NUMBER_MSG);
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
