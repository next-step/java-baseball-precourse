package baseball.controller;

import baseball.model.BaseballService;
import baseball.vo.GameResultStatus;

public class BaseballController {

    private BaseballService baseballService = new BaseballService();

    public void initRandomBaseballNumber() {
        baseballService.initRandomBaseballNumber();
    }

    public int inputAnyNumber() {
        return baseballService.inputAnyNumber();
    }

    public GameResultStatus checkGameRuleInputNumberAndRandomNumber(int inputAnyNumber) {
        return baseballService.checkGameRuleInputNumberAndRandomNumber(inputAnyNumber);
    }

    public void guideGameResult(GameResultStatus gameResultStatus) {
        baseballService.guideGameResult(gameResultStatus);
    }

    public boolean confirmRestartGame() {
        return baseballService.confirmRestartGame();
    }

}
