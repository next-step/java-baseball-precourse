package baseball.input;

import java.util.HashSet;
import java.util.Set;
import static baseball.input.InputErrorEnum.*;

public class InputValidator {
    private final String NUMBER_REGEX = "[0-9]+";

    public void hasDuplicateNumber(String input) {
        Set<Character> checkInputSet = new HashSet<>();
        for (char digit: input.toCharArray()) {
            checkInputSet.add(digit);
        }
        if(checkInputSet.size() != 3)
            throw new IllegalArgumentException(DUPLICATE.text());
    }

    public void isInputNumber(String input) {
        if(input.matches(NUMBER_REGEX)) return;
        throw new IllegalArgumentException(NOT_NUMERIC.text());
    }

}
