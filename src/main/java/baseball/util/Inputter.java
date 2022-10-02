package baseball.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class Inputter {
    private static final int FIXED_INPUT_LENGTH = 3;

    private Inputter() {
    }

    public static String readNumberStringFromUser() {
        String enteredValue = Console.readLine();
        validateInputLength(enteredValue);
        validateInputIsNumber(enteredValue);
        validateInputDuplicateNumber(enteredValue);
        return enteredValue;
    }

    public static String readExistGameFlag() {
        return Console.readLine();
    }

    private static void validateInputLength(String input) {
        if (input.length() != FIXED_INPUT_LENGTH) {
            throw new IllegalArgumentException("입력의 길이는 3이어야 합니다.");
        }
    }

    private static void validateInputIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private static void validateInputDuplicateNumber(String input) {
        Set<Character> duplicatedCheckSet = new HashSet<>();
        for (char c : input.toCharArray()) {
            duplicatedCheckSet.add(c);
        }
        if (duplicatedCheckSet.size() != 3) {
            throw new IllegalArgumentException("문자열 내 숫자는 중복될 수 없습니다.");
        }
    }
}
