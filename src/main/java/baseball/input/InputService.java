package baseball.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputService {
    private final InputValidator inputValidator;

    public InputService() {
        inputValidator = new InputValidator();
    }

    public List<Integer> getInput() {
        String input = Console.readLine();
        inputValidator.validateInput(input);
        return InputUtil.convertToIntegerList(input);
    }
}
