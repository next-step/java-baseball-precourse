package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;

public class Computer {

    private static HashSet<String> ballCount = new HashSet<>();

    private static final int BALLCOUNT_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static int getBallCountLength() {
        return BALLCOUNT_LENGTH;
    }

    public static HashSet<String> getBallCount() {
        return ballCount;
    }

    public static void throwBalls() {
        clearBallCount();
        while(ballCount.size() != BALLCOUNT_LENGTH) {
            storeBallCount();
        }
    }

    private static void storeBallCount() {
        String num = String.valueOf(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        ballCount.add(num);
    }

    private static void clearBallCount() {
        ballCount.clear();
    }
}
