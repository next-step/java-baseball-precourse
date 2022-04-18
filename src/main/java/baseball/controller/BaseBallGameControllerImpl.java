package baseball.controller;

import baseball.BBCODE;
import baseball.COMMAND;
import baseball.model.BaseBallGameModel;
import baseball.view.BaseBallGameView;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallGameControllerImpl implements BaseBallGameController{
    BaseBallGameModel model;
    BaseBallGameView view;
    public BaseBallGameControllerImpl(BaseBallGameModel model, BaseBallGameView view) {
        this.model = model;
        this.view = view;
    }
    @Override
    public void gameStart() {
        model.setTarget();
        this.playGame(BBCODE.NT);
    }

    private void playGame(BBCODE status) {
        while(status != BBCODE.THS) {
            view.reqNumber();
            String input = Console.readLine();
            if(isValidNumber(input)) {
                status = status.getCode(model.isBallCount(input), model.isStrikeCount(input));
                view.printCodeText(status);
            }
        }
        view.endGame();
        if(isContinue()) gameStart();
    }

    private boolean isValidNumber(String input) {
        if(!model.isValidNumber(input)) throw new IllegalArgumentException();
        return true;
    }

    private boolean isValidCommand(String input) {
        return input.equals(COMMAND.CONTINUE.code) || input.equals(COMMAND.END.code);
    }


    private boolean isContinue() {
        view.continueGame();
        String input = Console.readLine();
        if(!isValidCommand(input)) throw new IllegalArgumentException();
        return input.equals(COMMAND.CONTINUE.code);
    }
}
