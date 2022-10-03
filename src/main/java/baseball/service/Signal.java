package baseball.service;

import baseball.model.Count;
import baseball.model.NumberBaseBall;
import java.util.Objects;

public class Signal {

    public static Count gesture(NumberBaseBall answerNumberBaseBall, NumberBaseBall inputNumberBaseBall) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            boolean isBall = answerNumberBaseBall.contains(inputNumberBaseBall.get(i));
            boolean isStrike = Objects.equals(
                        answerNumberBaseBall.get(i), inputNumberBaseBall.get(i));

            ball = isBall && !isStrike ? ball + 1 : ball;
            strike = isStrike ? strike + 1 : strike;
        }

        return new Count(ball, strike);
    }
}
