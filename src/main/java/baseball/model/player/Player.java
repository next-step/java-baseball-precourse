package baseball.model.player;

import static baseball.constant.BaseballNumberEnum.MAX_DIGIT;
import static baseball.constant.BaseballNumberEnum.TARGET_LENGTH_FOR_CHECKING_STRING;
import static baseball.constant.BaseballStringEnum.INVALID_NUMBER_FOR_INPUT;
import static baseball.util.Util.getFirstLetter;
import static baseball.util.Util.getSubstring;


public class Player {
    String inputNumber;


    public String getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(String inputNumber) {
        if (!validateInput(inputNumber)) {
            throw new IllegalArgumentException(inputNumber);
        }
        this.inputNumber = inputNumber;
    }

    protected boolean validateInput(String inputNumber) {
        if (inputNumber.length() != MAX_DIGIT.intValue) {
            return false;
        }
        if (inputNumber.contains(INVALID_NUMBER_FOR_INPUT.label)) {
            return false;
        }
        return !checkContainDuplication(inputNumber);
    }

    protected boolean checkContainDuplication(String inputNumber) {
        if (isTargetLength(inputNumber)) {
            return false;
        }

        String firstLetter = getFirstLetter(inputNumber);
        String substring = getSubstring(inputNumber);

        if (substring.contains(firstLetter)) {
            return true;
        }

        return checkContainDuplication(substring);
    }

    protected boolean isTargetLength(String inputNumber) {
        return inputNumber.length() == TARGET_LENGTH_FOR_CHECKING_STRING.intValue;
    }

}
