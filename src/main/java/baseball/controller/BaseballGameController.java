package baseball.controller;

import baseball.domain.Hint;
import baseball.service.BaseballGameService;
import baseball.view.BaseballGameView;

import java.util.Map;

public class BaseballGameController {
    private final BaseballGameService baseballGameService;
    private final BaseballGameView view;

    public BaseballGameController(BaseballGameService baseballGameService, BaseballGameView view) {
        this.baseballGameService = baseballGameService;
        this.view = view;
    }

    public void startNewGame() {
        baseballGameService.startNewGame();
        Map<Hint, Integer> hintMap;
        do {
            hintMap = verifyAnswer();
            view.displayResult(hintMap);
        } while (!isGameOver(hintMap));

        String continueFlag = view.isContinueGame();
        isContinueGame(continueFlag);
    }

    private void isContinueGame(String continueFlag) {
        if ("1".equals(continueFlag)) {
            startNewGame();
        }

        if ("2".equals(continueFlag)) {
            endGame();
        }
    }

    public void endGame() {
        view.endGame();
    }

    public Map<Hint, Integer> verifyAnswer() {
        String candidateNumber = view.inputCandidateNumber();
        Map<Hint, Integer> hintMap = baseballGameService.verifyAnswer(candidateNumber);

        return hintMap;
    }

    private boolean isGameOver(Map<Hint, Integer> hintMap) {
        if (hintMap.containsKey(Hint.스트라이크) && hintMap.get(Hint.스트라이크) == 3) {
            view.correctAnswer();
            return true;
        }
        return false;
    }
}
