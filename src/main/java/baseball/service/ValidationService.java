package baseball.service;

import baseball.domain.Validation;

public class ValidationService {
    private final Validation validation;

    public ValidationService() {
        this.validation = new Validation();
    }

    public Boolean checkNum(String inputVal) {
        return validation.isNum(inputVal);
    }

    public Boolean checkCorrectLen(String inputVal) {
        return validation.isCorrectLength(inputVal);
    }

    public Boolean checkCorrectNum(String inputVal) {
        return validation.isDiffNum(inputVal);
    }

    public Boolean checkCorrectRange(String inputVal) {
        return validation.isCorrectRange(inputVal);
    }
}
