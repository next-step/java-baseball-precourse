package NumberBaseball.controller;

import NumberBaseball.model.BaseBallCount;
import NumberBaseball.model.NumberBaseballModel;
import NumberBaseball.view.NumberBaseballView;

import java.util.List;

public class NumberBaseballController {
    private final NumberBaseballModel model;
    private final NumberBaseballView view;

    public NumberBaseballController(NumberBaseballModel model, NumberBaseballView view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {
        while (model.isGameContinuing()) {
            playRound();
        }
    }

    private void playRound() {
        try {
            String input = view.displayRound();
            InputValidator.isValid(input);
            BaseBallCount baseBallCount = model.checkCount(List.of(input.split("")));
            view.displayResult(baseBallCount.getStrike(), baseBallCount.getBall());
            if (baseBallCount.getStrike() == model.getNumberLength()) {
                model.setGameContinuing(promptRestartGame());
            }
        } catch (Exception e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private boolean promptRestartGame() {
        while (true) {
            try {
                String restartOption = view.displayRestart();
                InputValidator.isRestartValid(restartOption);
                return model.processRestartOption(restartOption);
            } catch (Exception e) {
                view.displayErrorMessage(e.getMessage());
            }
        }
    }
}