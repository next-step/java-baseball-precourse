package baseball.domain;

import nextstep.utils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameBallGenerator {
    private static final int BALL_MIN_NUM = 1;
    private static final int BALL_MAX_NUM = 9;
    private static final int BALL_MAX_DIGIT = 3;

    private static List<Integer> generatedBaseballNums;

    public static List<Integer> generateBaseballNums() {
        generatedBaseballNums = new ArrayList<>();
        getDigitRandomNum();

        return generatedBaseballNums;
    }

    public static List<Integer> generateBaseballNums(String userInputNums) {
        generatedBaseballNums = new ArrayList<>();
        getDigitUserInputNum(userInputNums);

        return generatedBaseballNums;
    }

    public static void getDigitRandomNum() {
        do {
            getUniqueNum(Randoms.pickNumberInRange(BALL_MIN_NUM, BALL_MAX_NUM));
        } while (generatedBaseballNums.size() < BALL_MAX_DIGIT);
    }

    public static void getUniqueNum(int digitNum) {
        if (!generatedBaseballNums.contains(digitNum)) {
            generatedBaseballNums.add(digitNum);
        }
    }

    public static void getDigitUserInputNum(String userInputNums) {
        for (int i = 0; i < userInputNums.length(); i++) {
            getUniqueNum(Integer.parseInt(String.valueOf(userInputNums.charAt(i))));
        }
    }
}
