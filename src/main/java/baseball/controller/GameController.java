package baseball.controller;

import baseball.generator.HintGenerator;
import baseball.generator.InputGenerator;
import baseball.generator.NumberGenerator;
import baseball.validator.InputValidator;

import java.util.List;

public class GameController {

    public void baseballGame() {
        startGame(gameSetup());
    }

    private void startGame(List<Integer> answer) {
        while (true) {

            final String input = inputNumber(answer);
            if (isInputError(input)) {
                System.out.println(input);
                continue;
            }

            final List<Integer> inputList = InputGenerator.convertToIntegerList(input);
            answerCheck(inputList, answer);
        }
    }


    private List<Integer> gameSetup() {
        return NumberGenerator.makeThreeDigits();
    }

    private boolean isInputError(String input) {
        return input.startsWith("[ERROR]");
    }

    private void answerCheck(List<Integer> input, List<Integer> answer) {
        final HintGenerator hintGenerator = HintGenerator.of(input, answer);
        hintGenerator.getHint();
    }


    private String inputNumber(List<Integer> answer) {
        return InputValidator.validateInput(InputGenerator.inputThreeDigits());
    }




}