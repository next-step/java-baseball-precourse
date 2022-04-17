package baseball.input;

import java.util.HashSet;
import java.util.Set;
import static baseball.input.InputErrorEnum.*;

public class InputValidator {

    public void hasDuplicateNumber(String input) {
        Set<Character> checkInputSet = new HashSet<>();
        for (char digit: input.toCharArray()) {
            checkInputSet.add(digit);
        }
        if(checkInputSet.size() != 3)
            throw new IllegalArgumentException(DUPLICATE.text());
    }
}
