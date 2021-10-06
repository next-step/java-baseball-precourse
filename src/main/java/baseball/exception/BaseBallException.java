package baseball.exception;

import static baseball.constant.ErrorMessage.*;

public class BaseBallException {

    public static class InvalidBallFormatException extends RuntimeException {
        public InvalidBallFormatException() {
            super(INVALID_BALL_FORMAT);
        }
    }

    public static class InvalidBallRangeException extends RuntimeException {
        public InvalidBallRangeException() {
            super(INVALID_BALL_RANGE);
        }
    }

    public static class DuplicatedBallsException extends RuntimeException {
        public DuplicatedBallsException() {
            super(DUPLICATED_BALLS);
        }
    }

    public static class InvalidBallsLength extends RuntimeException {
        public InvalidBallsLength() {
            super(INVALID_BALLS_LENGTH);
        }
    }
}
