package baseball.domain;

import java.util.HashSet;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomPickBallsStrategyTest {

    @DisplayName("pickBalls 를 하면 서로 다른 3개의 Integer 를 갖는 List 가 생성된다.")
    @RepeatedTest(10)
    void pickBalls() {
        RandomPickBallsStrategy randomPickBallsStrategy = new RandomPickBallsStrategy();
        List<Integer> integers = randomPickBallsStrategy.pickBalls();
        HashSet<Integer> set = new HashSet<>(integers);
        Assertions.assertThat(set.size()).isEqualTo(3);
    }
}
