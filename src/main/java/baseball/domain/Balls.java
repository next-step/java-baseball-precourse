package baseball.domain;

import static baseball.domain.BallStatus.NOTHING;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {

    public static final int STANDARD_BALLS_SIZE = 3;
    private final List<Ball> balls;

    public Balls(List<Integer> numbers) {
        ballsValid(numbers);

        balls = new ArrayList<>();
        for (int i = 1; i <= STANDARD_BALLS_SIZE; i++) {
            balls.add(new Ball(numbers.get(i - 1), i));
        }
    }

    public GameResult makeGameResult(Balls targetBalls) {
        GameResult gameResult = new GameResult();
        for (Ball ball : targetBalls.balls) {
            gameResult.report(this.judgeBallStatus(ball));
        }
        return gameResult;
    }

    private BallStatus judgeBallStatus(Ball targetBall) {
        BallStatus ballStatus = NOTHING;
        for (Ball ball : balls) {
            ballStatus = compareBallStatus(ballStatus, ball.judgeBall(targetBall));
        }
        return ballStatus;
    }

    private BallStatus compareBallStatus(BallStatus now, BallStatus tobe) {
        if (!tobe.isNothing()) {
            return tobe;
        }
        return now;
    }


    private void ballsValid(List<Integer> numbers) {
        numbersSizeCheck(numbers.size());
        numberDistinctCheck(numbers);

    }

    private void numberDistinctCheck(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < STANDARD_BALLS_SIZE; i++) {
            set.add(numbers.get(i));
        }

        if (set.size() != STANDARD_BALLS_SIZE) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력하세요.");
        }

    }

    private void numbersSizeCheck(int size) {
        if (size != STANDARD_BALLS_SIZE) {
            throw new IllegalArgumentException("숫자는 3개만 가능합니다.");
        }
    }


}
