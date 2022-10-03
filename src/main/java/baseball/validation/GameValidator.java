package baseball.validation;

import baseball.constant.GameEnvironment;
import baseball.constant.GameStatus;
import baseball.util.DataConverter;
import java.util.List;
import java.util.Set;

public class GameValidator {
    public static boolean isValidGameNumbers(String input) {
        if (!(isValidRandomNumberSize(input.length()) && isConsistOfDigit(input))) {
            return false;
        }

        return isNotContainsDuplicatedNumber(input);
    }

    private static boolean isValidRandomNumberSize(int size) {
        return size == GameEnvironment.NUMBER_SIZE;
    }

    private static boolean isConsistOfDigit(String source) {
        return source.matches("^[0-9]+$");
    }

    private static boolean isNotContainsDuplicatedNumber(String input) {
        Set<Integer> numbers = DataConverter.stringToIntegerSet(input);
        return isValidRandomNumberSize(numbers.size());
    }

    public static boolean isValidRestartNumber(String input) {
        if (!isValidDigitSize(input)) {
            return false;
        }

        return isGameStatus(input);
    }

    private static boolean isValidDigitSize(String input) {
        return input.length() == 1;
    }

    private static boolean isGameStatus(String input) {
        int restartNumber = DataConverter.stringToDigit(input);
        List<Integer> gameStatusList = GameStatus.getStatusList();

        return gameStatusList.contains(restartNumber);
    }
}