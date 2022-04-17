package baseball.input;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static baseball.input.InputErrorEnum.*;

public class InputValidator {
    private final String NUMBER_REGEX = "[0-9]+";
    private final List<String> inputHistory = new ArrayList<>();

    public void validateInput(String input) {
        checkThreeDigits(input);
        checkNumeric(input);
        checkDuplicateNumber(input);
        alreadyChecked(input);
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

    private void checkNumeric(String input) {
        if(input.matches(NUMBER_REGEX)) return;
        throw new IllegalArgumentException(NOT_NUMERIC.text());
    }

    private void alreadyChecked(String input) {
        if(inputHistory.contains(input))
            throw new IllegalArgumentException(ALREADY_CHECKED.text());
        inputHistory.add(input);
    }
}
