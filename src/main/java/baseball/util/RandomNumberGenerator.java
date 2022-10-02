package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import static baseball.constant.BaseballProperties.RANDOM_RANGE_END;
import static baseball.constant.BaseballProperties.RANDOM_RANGE_START;

public class RandomNumberGenerator {

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_RANGE_START, RANDOM_RANGE_END);
    }
}
