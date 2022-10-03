package baseball.controller;

import baseball.domain.BaseballNumbers;
import baseball.domain.Game;
import baseball.domain.GameStatus;
import baseball.domain.Hint;
import baseball.view.MainView;

public class MainController {
    
    private Game game = null;

    public void start() {
        startValidate();

        game = new Game();

        requestBaseballNumbersForm();
    }

    private void requestBaseballNumbersForm() {
        MainView.baseballNumbersForm(this);
    }

    public void requestHint(BaseballNumbers playerNumbers) {
        Hint model = game.getHint(playerNumbers);
        MainView.printHint(model);
        
        if (isInProgress()) {
            requestBaseballNumbersForm();
        }
        
        if (isFinished()) {
            requestContinueForm();
        }
    }

    public void requestContinue(ContinueKey continueKey) {
        if (continueKey.equals(ContinueKey.START)) {
            restart();
        }

        if (continueKey.equals(ContinueKey.QUIT)) {
            quit();
        }
    }

    private void requestContinueForm() {
        MainView.continueForm(this);
    }

    private void restart() {
        initialized();
        start();
    }

    private void initialized() {
        game = null;
    }

    private void quit() {
        MainView.printQuit();
        System.exit(0);
    }

    private void startValidate() {
        if (isInProgress()) {
            throw new IllegalAccessError(
                    ErrorMessage.GAME_ALREADY_IN_PROGRESS_ERROR.getMessage());
        }
    }

    private boolean isInProgress() {
        return (!hasInitialized() && game.getStatus() == GameStatus.IN_PROGRESS);
    }

    private boolean isFinished() {
        return (!hasInitialized() && game.getStatus() == GameStatus.FINISHED);
    }

    private boolean hasInitialized() {
        return (game == null);
    }   
}
