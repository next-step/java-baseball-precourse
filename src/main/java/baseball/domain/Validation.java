package baseball.domain;

import baseball.common.Const;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    public Validation(List<Integer> userBaseballNumber) {
        validateIncludingZero(userBaseballNumber);
        validateSize(userBaseballNumber);
        validateDuplicate(userBaseballNumber);
    }

    private static void validateIncludingZero(List<Integer> numbers) {
        if (numbers.contains(Const.IMPOSSIBLE_NUMBER)) {
            throw new IllegalArgumentException(Const.IMPOSSIBLE_NUMBER_EXCEPTION);
        }
    }

    private void validateSize(List<Integer> userBaseballNumber) {
        if(userBaseballNumber.size() != Const.BALL_COUNT) {
            throw new IllegalArgumentException(Const.SIZE_EXCEPTION);
        }
    }

    private void validateDuplicate(List<Integer> userBaseballNumber) {
        Set<Integer> baseballNumberSet = new HashSet<>(userBaseballNumber);
        if (baseballNumberSet.size() != userBaseballNumber.size()) {
            throw new IllegalArgumentException(Const.DUPLICATE_EXCEPTION);
        }
    }

    public static boolean validateNumberFormat(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
            return true;
        } catch (NumberFormatException e) {
            throw new NumberFormatException(Const.NUMBER_FORMAT_EXCEPTION);
        }
    }
}