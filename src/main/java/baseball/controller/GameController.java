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

    /**
     * 게임을 시작하고 난 후 문제를 맞추면 게임을 계속 할지 중단할지 체크
     */
    public void baseballGame() {
        do {
          startGame(gameSetup());
        } while (!endGame());
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