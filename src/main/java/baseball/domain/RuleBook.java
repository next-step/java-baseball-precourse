package baseball.domain;

import java.util.HashSet;
import java.util.Set;

public class RuleBook {
    public final static String REGEX = "[0-9]+";
    public final static int NUMBER_SIZE = 3;

    public static boolean validateRule(String inputNumber) {
        if (validateNotNumber(inputNumber)) {
            return true;
        }
        if (validateNumberSize(inputNumber)) {
            return true;
        }
        return validateDuplicateNumber(inputNumber);
    }

    private static boolean validateNotNumber(String inputNumber) {
        if (!inputNumber.matches(RuleBook.REGEX)) {
            System.out.println("[ERROR] 입력값은 숫자만 가능합니다.");
            return true;
        }
        return false;
    }

    private static boolean validateNumberSize(String inputNumber) {
        if (inputNumber.length() != NUMBER_SIZE) {
            System.out.println("[ERROR] 입력된 숫자는 3자리이어야 합니다.");
            return true;
        }
        return false;
    }

    private static boolean validateDuplicateNumber(String inputNumber) {
        Set<Integer> basket = new HashSet<>();
        for (String str : inputNumber.split("")) {
            basket.add(Integer.parseInt(str));
        }
        if (basket.size() != NUMBER_SIZE) {
            System.out.println("[ERROR] 입력된 3개의 숫자 중 중복된 숫자가 있습니다.");
            return true;
        }
        return false;
    }
}
