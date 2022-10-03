package baseball.domain;

import static baseball.domain.Balls.STANDARD_BALLS_SIZE;
import static baseball.domain.Number.MAX_NUMBER;
import static baseball.domain.Number.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomPickBallsStrategy implements PickBallsStrategy {


    @Override
    public List<Integer> pickBalls() {

        Set<Integer> pickNumbers = new HashSet<>();

        while (pickNumbers.size() != STANDARD_BALLS_SIZE) {
            pickNumbers.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        }

        return new ArrayList<>(pickNumbers);
    }

}
