package baseball.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import baseball.code.BallConfig;
import baseball.domain.BallList;
import nextstep.utils.Randoms;

public class BallListGenerator {

    public static List<Integer> generateComputerBallList() {
        Set<Integer> ballSet = new LinkedHashSet<>();
        while (ballSet.size() < BallConfig.BALL_LIST_SIZE.getBallConfig()) {
            ballSet.add(
                    Randoms.pickNumberInRange(
                            BallConfig.BALL_RANGE_START.getBallConfig(),
                            BallConfig.BALL_RANGE_END.getBallConfig()
                    )
            );
        }
        return new ArrayList<>(ballSet);
    }


    public static BallList generateUserBallList(String enterValue) {
        BallListValidator.inputValidate(enterValue);
        return new BallList(
            Arrays.asList(
                Character.getNumericValue(enterValue.charAt(0)),
                Character.getNumericValue(enterValue.charAt(1)),
                Character.getNumericValue(enterValue.charAt(2))
            ));
    }
}
