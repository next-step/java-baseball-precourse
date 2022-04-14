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

    public PlayResult play(final List<Integer> userNumbers) {
        Map<BallStatus, Integer> statusMap = new HashMap<>();
        Balls userBalls = new Balls(userNumbers);
        for (final Ball ball : computerBalls){
            BallStatus status = userBalls.play(ball);
            statusMap.put(status, statusMap.getOrDefault(status, 0) + 1);
        }
        return new PlayResult(statusMap);
    }

    private Set<BallStatus> getPlayResult(final Ball userBall) {
        Set<BallStatus> result = new HashSet<>();
        for (final Ball ball : computerBalls) {
            result.add(ball.play(userBall));
        }
        return result;
    }
}
