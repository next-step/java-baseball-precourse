package baseball.interfaces.utils;

import java.security.InvalidParameterException;
import java.util.HashSet;

public class Validation {
    public static void validAnswerInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException err) {
            throw new InvalidParameterException("[ERROR] 숫자를 입력 해주세요");
        }
        if (input.length() != 3) {
            throw new InvalidParameterException("[ERROR] 세 자리 숫자를 입력 하여야 합니다.");
        }

        if (Validation.hasDuplicatedDigit(input)) {
            throw new InvalidParameterException("[ERROR] 서로 다른 세 숫자를 입력 하여야 합니다.");
        }


    }

    public static void validEndGameInput(String input) {
        // 1 or 2
        if (!input.equals("1") && !input.equals("2")) {
            throw new InvalidParameterException("[ERROR] 입력이 올바르지 않습니다. 다시 시작 하려면 1, 종료 하려면 2를 입력 해주세요.");
        }
    }

    private static boolean hasDuplicatedDigit(String str) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            set.add(Character.toString(str.charAt(i)));
        }

        return set.size() != 3;
    }
}
