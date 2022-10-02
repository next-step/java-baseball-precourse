package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BaseballNumber {

    public static final int NUMBER_COUNT = 3;
    private static final int COMPUTER_MIN_RANDOM_NUMBER = 1;
    private static final int COMPUTER_MAX_RANDOM_NUMBER = 9;
    private final String numberText;

    public BaseballNumber(String numberText) {
        if (!isValidNumber(numberText)) {
            throw new IllegalArgumentException("잘못된 수를 입력하셨습니다. 입력한 수:" + numberText);
        }
        this.numberText = numberText;
    }

    public static BaseballNumber createRandomNumber() {
        StringBuilder numberText = new StringBuilder();
        while (isNotThreeLength(numberText.toString())) {
            addNumber(numberText);
        }
        return new BaseballNumber(numberText.toString());
    }

    private static void addNumber(StringBuilder numberText) {
        int no = Randoms.pickNumberInRange(COMPUTER_MIN_RANDOM_NUMBER, COMPUTER_MAX_RANDOM_NUMBER);
        if (hasContainNumber(no, numberText.toString())) {
            return;
        }
        numberText.append(no);
    }

    private static boolean hasContainNumber(int no, String target) {
        return target.contains(String.valueOf(no));
    }

    private static boolean isValidNumber(String numberText) {
        if (isNotThreeLength(numberText)) {
            return false;
        }

        if (!isNumber(numberText)) {
            return false;
        }

        return !isDuplicateNumber(numberText);
    }

    private static boolean isNotThreeLength(String text) {
        return text.length() != NUMBER_COUNT;
    }

    private static boolean isDuplicateNumber(String numberText) {
        Set<String> numbers = new HashSet<>(Arrays.asList(numberText.split("")));
        return numbers.size() != NUMBER_COUNT;
    }

    private static boolean isNumber(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String getNumberText() {
        return numberText;
    }
}
