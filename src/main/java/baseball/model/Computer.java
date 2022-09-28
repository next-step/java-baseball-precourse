package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;

public class Computer {

    private static HashSet<Integer> ballCounts = new HashSet<>();

    private static final int BALLCOUNT_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static int getBallCountLength() {
        return BALLCOUNT_LENGTH;
    }

    public static HashSet<Integer> getBallCounts() {
        return ballCounts;
    }

    public static void throwBalls() {
        clearBallCounts();
        while(ballCounts.size() != BALLCOUNT_LENGTH) {
            storeBallCount();
        }
    }

    private static void storeBallCount() {
        int num = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        ballCounts.add(num);
    }

    private static void clearBallCounts() {
        ballCounts.clear();
    }
}
