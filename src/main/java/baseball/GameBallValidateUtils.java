package baseball;

import java.util.Collections;
import java.util.List;

public class GameBallValidateUtils {

    public static final int BASEBALL_MAX_NUM = 9;
    public static final int BASEBALL_MIN_NUM = 1;
    public static final int BASEBALL_MAX_DIGIT = 3;

    public static boolean isValidNumberRange(int userInputNumber) {
        return userInputNumber >= BASEBALL_MIN_NUM && userInputNumber <= BASEBALL_MAX_NUM;
    }

    public static boolean isValidNumbersRange(List<Integer> userInputNumbers) {
        boolean isValidNum = true;

        for (Integer num : userInputNumbers) {
            isValidNum = isValidNumberRange(num);
            if (!isValidNum) break;
        }
        return isValidNum;
    }

    public static boolean isValidNumbersDigit(List<Integer> userInputNumbers) {
        return userInputNumbers.size() == BASEBALL_MAX_DIGIT;
    }

    public static boolean isDulicateNumbers(List<Integer> userInputNumbers) {
        boolean isDuplicate = false;

        for (int i = 0; i < userInputNumbers.size(); i++) {
            isDuplicate = verifyDuplicate(userInputNumbers, userInputNumbers.get(i));
            if (isDuplicate) break;
        }
        return isDuplicate;
    }

    private static boolean verifyDuplicate(List<Integer> gameBallNums, int ballNum) {
        if (Collections.frequency(gameBallNums, ballNum) > 1) {
            return true;
        }
        return false;
    }
}
