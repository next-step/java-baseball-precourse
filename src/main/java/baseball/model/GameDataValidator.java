package baseball.model;

import java.util.HashSet;
import java.util.List;

public class GameDataValidator {
    public static void validateOrder(int order) {
        if (order < 0) {
            throw new IllegalArgumentException();
        }

        if (BaseballGameRule.PITCHING_COUNT <= order) {
            throw new IllegalArgumentException();
        }
    }

    private static void validatePitchingCount(int count) {
        if (count != BaseballGameRule.PITCHING_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicatedNumber(List<Integer> numberList) {
        if (new HashSet<>(numberList).size() != BaseballGameRule.PITCHING_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateNumber(int number) {
        if (BaseballGameRule.MINIMUM_NUMBER > number || number > BaseballGameRule.MAXIMUM_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateNumberList(List<Integer> numberList) {
        GameDataValidator.validatePitchingCount(numberList.size());
        for (Integer number : numberList) {
            GameDataValidator.validateNumber(number);
        }
        validateDuplicatedNumber(numberList);
    }
}
