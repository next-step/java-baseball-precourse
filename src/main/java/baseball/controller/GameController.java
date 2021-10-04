package baseball.controller;

import baseball.generator.HintGenerator;
import baseball.generator.InputGenerator;
import baseball.generator.NumberGenerator;
import baseball.message.error.ErrorCode;
import baseball.message.text.TextMessage;
import baseball.validator.InputValidator;
import nextstep.utils.Console;

import java.util.List;

public class GameController {

    public void baseballGame() {
        while (true) {
            startGame(gameSetup());
            if (endGame()) {
                break;
            }
        }
    }

    private void startGame(List<Integer> answer) {
        while (true) {

            final String input = inputNumber();
            if (isInputError(input)) {
                System.out.println(input);
                continue;
            }

            final List<Integer> inputList = InputGenerator.convertToIntegerList(input);
            if (answerCheck(inputList, answer)) {
                break;
            }
        }
    }


    private List<Integer> gameSetup() {
        return NumberGenerator.makeThreeDigits();
    }

    private boolean isInputError(String input) {
        return input.startsWith(ErrorCode.ERROR);
    }

    private boolean answerCheck(List<Integer> input, List<Integer> answer) {
        return HintGenerator.of(input, answer).getHint();
    }


    private String inputNumber() {
        return InputValidator.validateInput(InputGenerator.inputThreeDigits());
    }

    private boolean endGame() {
        while (true) {
            System.out.print(TextMessage.CONTINUE_OR_END);
            final String kb = Console.readLine();
            if ("1".equals(kb)) {
                return false;
            }
            if ("2".equals(kb)) {
                return true;
            }
        }
    }



}