package baseball.domain;

import baseball.constant.Const;
import baseball.enums.ErrorMessageEnum;
import baseball.exception.InvalidUserInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class User {
    private final List<Integer> numbers = new ArrayList<>(Const.GENERATE_NUMBER_SIZE);

    public void initNumber(String receiveUserInput) {
        numbers.clear();
        String[] splitUserInputArray = receiveUserInput.split("");
        checkUserInputNumberCount(splitUserInputArray);
        for (String splitNumber : splitUserInputArray) {
            checkUserInputNumberType(splitNumber);
            checkUserInputNumberDuplicate(Integer.parseInt(splitNumber));
            numbers.add(Integer.parseInt(splitNumber));
        }
    }

    public boolean isGameStop(String receiveUserInput) {
        checkUserInputNumberType(receiveUserInput);
        return Integer.parseInt(receiveUserInput) == Const.RESTART_FLAG;
    }

    private void checkUserInputNumberCount(String[] input) {
        if (input.length != Const.GENERATE_NUMBER_SIZE) {
            throw new InvalidUserInputException(ErrorMessageEnum.INVALID_LENGTH_ERROR.getMessage());
        }
    }

    private void checkUserInputNumberType(String input) {
        if (!Pattern.matches(Const.NUMBER_REGEX, input)) {
            throw new InvalidUserInputException(ErrorMessageEnum.INVALID_TYPE_ERROR.getMessage());
        }
    }

    private void checkUserInputNumberDuplicate(int input) {
        if (numbers.contains(input)) {
            throw new InvalidUserInputException(ErrorMessageEnum.DUPLICATE_NUMBER_ERROR.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
