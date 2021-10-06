package baseball.exception;

import static baseball.constant.ErrorMessage.*;

public class BaseballException {

    public static class InvalidBallFormatException extends RuntimeException {
        public InvalidBallFormatException() {
            super(INVALID_BALL_FORMAT);
        }
        public InvalidBallFormatException(String message) {
            super(message);
        }
    }

    public static class InvalidRangeException extends RuntimeException {
        public InvalidRangeException() {
            super(INVALID_RANGE);
        }
        public InvalidRangeException(String message) {
            super(message);
        }
    }

    public static class DuplicatedBallsException extends RuntimeException {
        public DuplicatedBallsException() {
            super(DUPLICATED_BALLS);
        }
        public DuplicatedBallsException(String message) {
            super(message);
        }
    }

    public static class InvalidBallsLength extends RuntimeException {
        public InvalidBallsLength() {
            super(INVALID_BALLS_LENGTH);
        }
        public InvalidBallsLength(String message) {
            super(message);
        }
    }
}
