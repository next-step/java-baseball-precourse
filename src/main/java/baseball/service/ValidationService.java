package baseball.service;

import baseball.domain.ValidateValue;

public class ValidationService {

    private final ValidateValue validateValue;

    public ValidationService() {
        this.validateValue = new ValidateValue();
    }

    public Boolean checkNum(String inputVal) {
        return validateValue.isNum(inputVal);
    }

    public Boolean checkCorrectLen(String inputVal) {
        return validateValue.isCorrectLength(inputVal);
    }

    public Boolean checkCorrectNum(String inputVal) {
        return validateValue.isDiffNum(inputVal);
    }
}
