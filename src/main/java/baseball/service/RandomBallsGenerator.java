package baseball.service;

import baseball.domain.ball.Balls;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import static baseball.constant.Rule.*;

public class RandomBallsGenerator implements BallsGenerator {
    @Override
    public Balls generate() {
        Set<Integer> number = new LinkedHashSet<>();
        while (number.size() < COUNT_OF_BALLS) {
            number.add(Randoms.pickNumberInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER));
        }
        return Balls.valueOf(new ArrayList<>(number));
    }
}
