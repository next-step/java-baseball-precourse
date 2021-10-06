package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private static final int START = 0;
    private static final int END = 3;
    private static final int PLUS_INDEX = 1;

    private final List<Ball> balls;

    public Balls(List<Integer> ballNumber) {
        this.balls = initBalls(ballNumber);
    }

    private List<Ball> initBalls(List<Integer> ballNumber) {
        List<Ball> inputBalls = new ArrayList<>();
        System.out.println(ballNumber);
        for (int i = START; i < END; i++) {
            inputBalls.add(new Ball(i + PLUS_INDEX, ballNumber.get(i)));
        }
        return inputBalls;
    }

    public PlayResult play(Balls balls) {
        List<Ball> userBalls = balls.getBalls();
        PlayResult playResult = new PlayResult();
        for (Ball userBall : userBalls) {
            playResult.increaseCount(this.play(userBall));
        }

        return playResult;
    }

    private BallStatus play(Ball userBall) {
        int index = START;
        BallStatus status = BallStatus.NOTHING;
        while (isCheckedStatus(status, index)) {
            Ball ball = balls.get(index ++);
            status = userBall.play(ball);
        }

        return status;
    }

    private boolean isCheckedStatus(BallStatus status, int index) {
        return index < END && status == BallStatus.NOTHING;
    }

    private BallStatus status(BallStatus status) {
        return status;
    }

    private List<Ball> getBalls() {
        return balls;
    }
}
