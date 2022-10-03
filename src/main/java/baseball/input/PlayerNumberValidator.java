package baseball.input;

import baseball.constants.Condition;
import baseball.constants.Regex;
import baseball.input.bean.Player;

import java.util.Arrays;
import java.util.HashSet;

public class PlayerNumberValidator {

    private Player player;

    public void validateNumber(String number) {
        checkInvalidEmptyNumber(number);
        if (checkValidRestartOrExitCode(number)) return;

        String[] digits = number.split(Regex.SPLIT_REGEX);
        checkInvalidDigitSize(digits);
        checkInvalidDistinctedDigitSize(digits);
    }

    private void checkInvalidDistinctedDigitSize(String[] digits) {
        int distinctedDigitSize = new HashSet<String>(Arrays.asList(digits)).size();
        if(distinctedDigitSize != Condition.DIGIT_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void checkInvalidDigitSize(String[] digits) {
        for (String digit : digits) {
            if(!digit.matches(Regex.CHECK_NUMBER_FORMAT)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean checkValidRestartOrExitCode(String number) {
        if(Condition.INPUT_RESTART.equals(number) || Condition.INPUT_EXIT.equals(number)) {
            return true;
        }
        return false;
    }

    private void checkInvalidEmptyNumber(String number) {
        if(number == null || number.isEmpty() || number.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
