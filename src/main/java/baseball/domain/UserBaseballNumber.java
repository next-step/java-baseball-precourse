package baseball.domain;

import baseball.exception.BaseballException;
import baseball.exception.ErrorMessage;

import java.util.*;
import java.util.regex.Pattern;

public class UserBaseballNumber implements BaseballNumber {
    private static final int MAX_NUMBER_LENGTH = 3;
    private static final int START_INDEX = 0;
    private final Pattern numberPattern = Pattern.compile("^[1-9]*$");

    private String inputNumber;

    public UserBaseballNumber(String inputNumber) {
        this.inputNumber = inputNumber;
    }

    @Override
    public List<Integer> createNumbers() {
        Set<Integer> userNumbers = new LinkedHashSet<>();
        for (int i = START_INDEX; i < MAX_NUMBER_LENGTH; i++) {
            userNumbers.add(Character.getNumericValue(inputNumber.charAt(i)));
        }

        return new ArrayList<>(userNumbers);
    }

    public void validate() {
        validateEscape(inputNumber);
        validateDigit(inputNumber);
        validateDuplication(inputNumber);
    }

    public void validateEscape(String inputNumber) {
        if (!numberPattern.matcher(inputNumber).find()) {
            throw new BaseballException(ErrorMessage.ESCAPE_NUMBER_EXCEPTION);
        }
    }

    public void validateDigit(String inputNumber) {
        if (inputNumber.length() != MAX_NUMBER_LENGTH) {
            throw new BaseballException(ErrorMessage.THREE_NUMBER_EXCEPTION);
        }
    }

    public void validateDuplication(String inputNumber) {
        Set<String> convertInputNumber = new LinkedHashSet<>(Arrays.asList(inputNumber.split("")));
        if (convertInputNumber.size() != MAX_NUMBER_LENGTH) {
            throw new BaseballException(ErrorMessage.DUPLICATE_NUMBER_EXCEPTION);
        }
    }
}
