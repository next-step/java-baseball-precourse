package baseball;

import baseball.common.GameProgressStep;
import baseball.controller.BaseBallController;
import baseball.dto.BaseballDTO;
import baseball.handler.UserInputHandler;
import baseball.view.BaseBallView;

public class BaseBallGame {

    private final BaseBallController baseBallController;
    private final BaseBallView baseBallView;
    private final UserInputHandler userInputHandler;

    public BaseBallGame() {
        this.baseBallController = new BaseBallController();
        this.baseBallView = new BaseBallView();
        this.userInputHandler = new UserInputHandler();
    }

    public boolean run() {
        baseBallController.initAnswer();

        boolean isCorrect;
        do {
            baseBallView.printInput();
            final String userAnswer = userInputHandler.inputAnswer();
            isCorrect = submitAnswer(userAnswer);
        } while(!isCorrect);

        return isReGame();
    }

    private boolean submitAnswer(final String userAnswer) {
        final BaseballDTO.ResResult result = baseBallController.submitAnswer(userAnswer);

        baseBallView.printScore(result);

        return result.isCorrect();
    }

    private boolean isReGame() {
        baseBallView.printReGame();

        final int selectedProgress = userInputHandler.inputProgressStep();

        return GameProgressStep.NEW_GAME == GameProgressStep.findProgressStep(selectedProgress);
    }
}
