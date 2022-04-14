package baseball.balls;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class Balls {

    private final List<Ball> computerBalls;

    public Balls(final List<Integer> list) {
        computerBalls = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            computerBalls.add(new Ball(i, list.get(i)));
        }
    }

    public BallStatus play(final Ball userBall) {
        Set<BallStatus> result = getPlayResult(userBall);
        if (result.contains(BallStatus.STRIKE)) {
            return BallStatus.STRIKE;
        }
        if (result.contains(BallStatus.BALL)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private Set<BallStatus> getPlayResult(final Ball userBall) {
        Set<BallStatus> result = new HashSet<>();
        for (final Ball ball : computerBalls) {
            result.add(ball.play(userBall));
        }
        return result;
    }
}
