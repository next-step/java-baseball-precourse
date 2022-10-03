package baseball.validator;

import baseball.constant.ValidatorConstant;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class BallNumberValidator implements Validator {

    @Override
    public void valid(String inputNumber) {
        checkNumberLength(inputNumber);
        checkNumberRegex(inputNumber);
        checkDuplicate(inputNumber);
    }

    private void checkNumberLength(String inputNumber) {
        if (inputNumber.length() != ValidatorConstant.MAX_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumberRegex(String inputNumber) {
        if (!inputNumber.matches(ValidatorConstant.NUMBER_REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(String inputNumber) {
        String[] inputNumbers = inputNumber.split("");
        Set<String> numberCheckers = new HashSet<>();
        Collections.addAll(numberCheckers, inputNumbers);
        if (numberCheckers.size() < ValidatorConstant.MAX_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

}
