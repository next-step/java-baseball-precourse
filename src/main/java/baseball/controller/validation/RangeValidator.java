package baseball.controller.validation;

import java.util.regex.Pattern;

public class RangeValidator implements Validator {
    @Override
    public void check(String input) {
        String regex = "^[1-9][1-9][1-9]$";
        if (!Pattern.matches(regex, input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
