package baseball.domain.validator;

import baseball.domain.GameRule;
import baseball.domain.message.ErrorMessage;
import java.util.Arrays;
import java.util.HashSet;

public class NumbersValidator {
    GameRule gameRule;
    private final String regx;

    public NumbersValidator(GameRule gameRule) {
        this.gameRule = gameRule;
        this.regx = "[" + gameRule.MIN_NUM + "-" + gameRule.MAX_NUM + "]+";
    }

    public boolean isNumbersValidate(String numberString) {

        if (isOutOfSize(numberString)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_OUT_OF_SIZE);
        }

        if (isNotNumber(numberString)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMBER);
        }

        if (isDuplicateInNumbers(numberString)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATE_NUMBER);
        }

        return true;
    }

    private boolean isNotNumber(String numberString) {
        return !numberString.matches(regx);
    }

    private boolean isOutOfSize(String numberString) {
        return numberString.length() != gameRule.SIZE;
    }

    private boolean isDuplicateInNumbers(String numberString) {
        HashSet<String> checkNumberSet = new HashSet<>(Arrays.asList(numberString.split("")));
        return checkNumberSet.size() != gameRule.SIZE;
    }
}
