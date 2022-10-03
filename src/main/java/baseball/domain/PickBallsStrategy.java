package baseball.domain;

import java.util.List;

@FunctionalInterface
public interface PickBallsStrategy {

    List<Integer> pickBalls();
}
