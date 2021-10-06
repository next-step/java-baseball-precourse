package baseball.domain;

import baseball.GameBallValidateUtils;

import java.util.List;

public class GameBall {
    private final List<Integer> ballNums;
    private GameResult result;
    private static final int BALL_MAX_DIGIT = 3;

    public static final String INVALID_RANGE_MESSAGE = "유효한 범위의 값이 아닙니다.";
    public static final String DUPLICATE_MESSAGE = "중복된 값이 있습니다.";
    public static final String INVALID_DIGIT_MESSAGE ="유효한 자릿수가 아닙니다.";

    public GameBall(List<Integer> ballNums) {
        validateBallNums(ballNums);
        this.ballNums = ballNums;
    }

    public GameResult playball(GameBall userInputBall) {
        this.result = new GameResult();

        for (int i = 0; i < BALL_MAX_DIGIT; i++) {
            verifyStrike(userInputBall.ballNums, i);
            verifyBall(userInputBall.ballNums, i);
        }
        return this.result;
    }

    private void verifyStrike(List<Integer> userBallsNum, int index) {
        if (ballNums.get(index).equals(userBallsNum.get(index))) {
            this.result.setStrike();
        }
    }

    private void verifyBall(List<Integer> userBallsNum, int index) {
        if (!ballNums.get(index).equals(userBallsNum.get(index)) && ballNums.contains(userBallsNum.get(index))) {
            this.result.setBall();
        }
    }

    private void validateBallNums(List<Integer> ballNums) {
        if (!GameBallValidateUtils.isValidNumbersDigit(ballNums)) {
            throw new IllegalArgumentException(INVALID_DIGIT_MESSAGE);
        }

        if (!GameBallValidateUtils.isValidNumbersRange(ballNums)) {
            throw new IllegalArgumentException(INVALID_RANGE_MESSAGE);
        }

        if (GameBallValidateUtils.isDulicateNumbers(ballNums)) {
            throw new IllegalArgumentException(DUPLICATE_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return "GameBall = " + ballNums;
    }
}
