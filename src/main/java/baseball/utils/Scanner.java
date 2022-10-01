package baseball.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Scanner {

    private static final String NUMBER_PATTERN = "^[\\d]+$";
    private static final String SAME_NUMBER_PATTERN = "(\\w)\\1";
    private static final String COMMAND_PATTERN = "^[\\d]{1}$";
    private static final String SWING_PATTERN = "^[\\d]{3}$";

    private Scanner() {
    }

    public static int gameCommand() {
        String input = Console.readLine();
        validateCommandInput(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> swingNumber() {
        List<Integer> swingNumbers = new ArrayList<>();
        String input = Console.readLine();
        validateSwingInput(input);
        for (String swingNumber : input.split("")) {
            swingNumbers.add(Integer.parseInt(swingNumber));
        }
        return swingNumbers;
    }

    private static void validateCommandInput(String input) {
        isNumber(input);
        validateCommandLength(input);
    }

    private static void validateSwingInput(String input) {
        isNumber(input);
        isSameNumber(input);
        validateSwingLength(input);
    }

    private static void isNumber(String input) {
        if (!Pattern.compile(NUMBER_PATTERN).matcher(input).find()) {
            throw new IllegalArgumentException("숫자 이외에 값이 입력되었습니다.");
        }
    }

    private static void isSameNumber(String input) {
        if (Pattern.compile(SAME_NUMBER_PATTERN).matcher(input).find()) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해야합니다.");
        }
    }

    private static void validateCommandLength(String input) {
        if (!Pattern.compile(COMMAND_PATTERN).matcher(input).find()) {
            throw new IllegalArgumentException("1자리에 숫자가 입력되야 합니다.");
        }
    }

    private static void validateSwingLength(String input) {
        if (!Pattern.compile(SWING_PATTERN).matcher(input).find()) {
            throw new IllegalArgumentException("3자리에 숫자가 입력되야 합니다.");
        }
    }

}
