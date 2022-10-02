package baseball.domain.player;

import baseball.domain.ball.Balls;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class RandomBallGeneratePolicy implements BallGeneratePolicy {

    @Override
    public Balls generate() {
        return Balls.from(createRandomNumbers());
    }

    private Set<Integer> createRandomNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 3) {
            numbers.add(Randoms.pickNumberInRange(1, 9));
        }
        return numbers;
    }
}
