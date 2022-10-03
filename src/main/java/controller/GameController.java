package controller;

import domain.EvaluatedResult;
import domain.GeneratedNumbers;
import domain.InputNumbers;
import view.GameConsoleView;

public class GameController {

    private GeneratedNumbers generatedNumbers;

    public GameController() {
    }

    public void startGame() {
        while(true) {
            createGeneratedNumbers();
            boolean isRestart = playGame();
            if(!isRestart) break;
        }
    }

    private void createGeneratedNumbers() {
        this.generatedNumbers = new GeneratedNumbers();
    }

    private boolean playGame() {
        while(true) {
            String input = requestInput();
            InputNumbers inputNumbers = new InputNumbers(input);
            EvaluatedResult evaluatedResult = new EvaluatedResult(generatedNumbers, inputNumbers);
            GameConsoleView.printHint(evaluatedResult);
            if(evaluatedResult.getResult().getStrike() == 3) {
                return GameConsoleView.requestRestart();
            }
        }
    }

    private String requestInput() {
        GameConsoleView.printInputInstruction();
        return GameConsoleView.getInput();
    }
}
