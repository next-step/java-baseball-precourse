package baseball.controller;

import baseball.domain.ValidateValue;
import nextstep.utils.Console;

public class UserController {

    private ValidateValue validateValue;

    public UserController() {
        this.validateValue = new ValidateValue();
    }

    public Boolean checkNum (String inputVal) {
        if (validateValue.isNum(inputVal)) {
            return true;
        }
        return false;
    }

    public Boolean checkCorrectLen (String inputVal) {
        if (validateValue.isCorrectLength(inputVal)) {
            return true;
        }
        return false;
    }

    public Boolean checkCorrectNum (String inputVal) {
        if (validateValue.isDiffNum(inputVal)) {
            return true;
        }
        return false;
    }
}
