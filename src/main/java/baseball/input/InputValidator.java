package baseball.input;

import java.util.HashSet;
import java.util.Set;
import static baseball.input.InputErrorEnum.*;

public class InputValidator {
    private final String NUMBER_REGEX = "[0-9]+";

    public void validateInput(String input) {
        checkDuplicateNumber(input);
        checkThreeDigits(input);
        checkNumber(input);
    }

    private void checkDuplicateNumber(String input) {
        Set<Character> checkInputSet = new HashSet<>();
        for (char digit: input.toCharArray()) {
            checkInputSet.add(digit);
        }
        if(checkInputSet.size() != 3)
            throw new IllegalArgumentException(DUPLICATE.text());
    }

    private void checkThreeDigits(String input) {
        if(input.length() != 3)
            throw new IllegalArgumentException(NOT_THREE_DIGITS.text());
    }

    private void checkNumber(String input) {
        checkNumeric(input);
        int inputNumber = Integer.parseInt(input);
        checkPositive(inputNumber);
    }

    private void checkNumeric(String input) {
        if(input.matches(NUMBER_REGEX)) return;
        throw new IllegalArgumentException(NOT_NUMERIC.text());
    }

    private void checkPositive(int inputNumber) {
        if(inputNumber < 0)
            throw new IllegalArgumentException(NOT_POSITIVE.text());
    }
}
