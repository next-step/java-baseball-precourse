package baseball.controller;

import baseball.generator.InputGenerator;
import baseball.generator.NumberGenerator;
import baseball.validator.InputValidator;

import java.util.List;

public class GameController {

    public void baseballGame() {
        startGame(gameSetup());
    }

    private List<Integer> gameSetup() {
        return NumberGenerator.makeThreeDigits();
    }

    private void startGame(List<Integer> answer) {
        while (true) {
            final String input = inputNumber(answer);
            if (input.startsWith("[ERROR")) {
                System.out.println(input);
                continue;
            }
        }
    }

    private String inputNumber(List<Integer> answer) {
        return InputValidator.validateInput(InputGenerator.inputThreeDigits());
    }




}