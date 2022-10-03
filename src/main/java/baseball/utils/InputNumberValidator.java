package baseball.utils;

import baseball.common.Constants;
import baseball.common.Message;
import baseball.view.OutputProvider;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputNumberValidator {
    public boolean validateInput(String inputNumbers) {
        this.validateNumber(inputNumbers);
        this.validateSize(inputNumbers);
        this.validateDuplication(inputNumbers);
        return true;
    }

    private void validateNumber(String inputNumbers) {
        if (!inputNumbers.matches("[1-9]+")) {
            OutputProvider.printWrongNumber();
            throw new IllegalArgumentException(Message.ERROR_WRONG_INPUT);
        }
    }

    private void validateSize(String inputNumbers) {
        if (!(inputNumbers.length() == Constants.NUMBER_SIZE)) {
            OutputProvider.printWrongSize();
            throw new IllegalArgumentException(Message.ERROR_WRONG_SIZE);
        }
    }

    private void validateDuplication(String inputNumbers) {
        Set<String> numbers = new HashSet<>(Arrays.asList(inputNumbers.split("")));
        if (numbers.size() != Constants.NUMBER_SIZE) {
            OutputProvider.printDuplication();
            throw new IllegalArgumentException(Message.ERROR_INPUT_DUPLICATION);
        }
    }

    public void validateRetryOption(String inputNumber) {
        if (!inputNumber.matches("[1-2]")) {
            OutputProvider.printWrongNumber();
            throw new IllegalArgumentException(Message.ERROR_WRONG_INPUT);
        }
    }
}
