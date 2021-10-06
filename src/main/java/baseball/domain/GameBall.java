package baseball.domain;

import java.util.List;

public class GameBall {
    private final List<Integer> ballNums;
    private GameResult result;
    private static final int BALL_MAX_DIGIT = 3;

    public GameBall(List<Integer> ballNums) {
        this.ballNums = ballNums;
    }

    public GameResult playball(GameBall userInputBall) {
        this.result = new GameResult();

        for(int i = 0; i < BALL_MAX_DIGIT; i++) {
            verifyStrike(userInputBall.ballNums,i);
            verifyBall(userInputBall.ballNums,i);
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

    @Override
    public String toString() {
        return "GameBall = " + ballNums;
    }
}
