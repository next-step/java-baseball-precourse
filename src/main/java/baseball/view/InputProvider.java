package baseball.view;

import baseball.utils.InputNumberValidator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputProvider {
    public static String requestInput() {
        InputNumberValidator inputNumberValidator = new InputNumberValidator();
        OutputProvider.printInputNumbers();
        String inputNumbers = readLine();
        inputNumberValidator.validateInput(inputNumbers);
        return inputNumbers;
    }

    public static String retryOptionInput() {
        InputNumberValidator inputNumberValidator = new InputNumberValidator();
        String inputNumber = readLine();
        inputNumberValidator.validateRetryOption(inputNumber);
        return inputNumber;
    }
}
