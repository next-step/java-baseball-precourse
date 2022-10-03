package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Computer {

    private static LinkedHashSet<String> ballCount = new LinkedHashSet<>();

    private final int BALLCOUNT_LENGTH = 3;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;

    public int getBallCountLength() {
        return BALLCOUNT_LENGTH;
    }

    public static HashSet<String> getBallCount() {
        return ballCount;
    }

    public void throwBalls() {
        clearBallCount();
        while(ballCount.size() != BALLCOUNT_LENGTH) {
            storeBallCount();
        }
    }

    private void storeBallCount() {
        String num = String.valueOf(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        ballCount.add(num);
    }

    private void clearBallCount() {
        ballCount.clear();
    }
}
