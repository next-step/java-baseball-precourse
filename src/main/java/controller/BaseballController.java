package controller;

import domain.baseball.BaseballGame;
import domain.baseball.Hint;
import view.InputValidator;
import view.InputView;
import view.OutputView;

public class BaseballController {


    private final BaseballGame baseballGame;
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;

    public BaseballController(){
        baseballGame = new BaseballGame();
        inputView = new InputView();
        outputView = new OutputView();
        inputValidator = new InputValidator();
    }

    public void run() {
        while (true) {
            start();
            if(isEnd()){
                return;
            }
        }
    }

    public void start() {
        baseballGame.initComputerNumber();
        while (true) {
            Hint hint = getHint();
            outputView.displayHint(hint);
            if (hint != null && hint.isThreeStrike()) {
                outputView.displayCorrectAnswer();
                outputView.displaySelect();
                return;
            }
        }
    }

    public boolean isEnd(){
        int command = inputView.input();
        while (!inputValidator.isValidCommand(command)) {
            outputView.printError();
            outputView.displaySelect();
            command = inputView.input();
        }
        return baseballGame.isQuit(command);
    }

    private Hint getHint() {
        outputView.displayInputNumbers();
        int number = inputView.input();
        if (!inputValidator.isValidNumber(number)) {
            return null;
        }
        return baseballGame.updateHint(number);
    }
}
