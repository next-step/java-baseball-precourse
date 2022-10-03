package baseball.controller.validation;

public class LengthValidator implements Validator {

    @Override
    public void check(String input) {
        if (input.length() != LIMIT_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
