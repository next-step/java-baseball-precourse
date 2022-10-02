package baseball.domain;

import baseball.etc.GameManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {
    private final List<Ball> balls;

    public Balls(final List<Ball> balls) {
        duplicationValidation(balls);
        ballsSizeValidation(balls);
        this.balls = balls;
    }

    public static Balls of(final List<Integer> ballNumbers) {
        List<Ball> ballList = new ArrayList<>();
        for (int i = 0; i < ballNumbers.size(); i++) {
            ballList.add(new Ball(i, ballNumbers.get(i)));
        }
        return new Balls(ballList);
    }

    public PlayResult inning(final Balls user) {
        PlayResult playResult = new PlayResult();
        for (final Ball ball : this.balls) {
            playResult.report(user.play(ball));
        }
        return playResult;
    }

    public BallStatus play(final Ball otherBall) {
        Set<BallStatus> statusSet = new HashSet<>();
        for (final Ball ball : this.balls) {
            statusSet.add(ball.play(otherBall));
        }
        return findFirstNonNothingStatus(statusSet);
    }

    private BallStatus findFirstNonNothingStatus(final Set<BallStatus> statusSet) {
        if (statusSet.contains(BallStatus.STRIKE)) {
            return BallStatus.STRIKE;
        }
        if (statusSet.contains(BallStatus.BALL)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private void duplicationValidation(final List<Ball> balls) {
        Set<Integer> set = new HashSet<>();
        for (final Ball ball : balls) {
            set.add(ball.getNumber());
        }
        if (set.size() != GameManager.BALLS_SIZE) {
            throw new IllegalArgumentException("옳바른 입력이 아닙니다.");
        }
    }

    private void ballsSizeValidation(final List<Ball> balls) {
        if (balls.size() != GameManager.BALLS_SIZE) {
            throw new IllegalArgumentException("옳바른 입력이 아닙니다.");
        }
    }
}
