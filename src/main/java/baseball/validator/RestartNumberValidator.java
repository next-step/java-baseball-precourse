package baseball.validator;

import baseball.constant.ValidatorConstant;

public class RestartNumberValidator implements Validator {

    @Override
    public void valid(String inputNumber) {
        if (!inputNumber.matches(ValidatorConstant.RESTART_NUMBER_REGEX)) {
            throw new IllegalArgumentException();
        }
    }

}
