package baseball.controller;

import baseball.model.BaseballGameService;
import baseball.view.BaseballGameView;
import baseball.vo.CompareResultVO;

public class BaseballGameController {

    private final BaseballGameService baseballGameService = new BaseballGameService();
    private final BaseballGameView baseballGameView = new BaseballGameView();

    public void newGame() {
        baseballGameService.createAnswer();
    }

    public String inputNumberView() {
        return baseballGameView.inputNumber();
    }

    public String newOrExitGameView() {
        return baseballGameView.newOrExitGame();
    }

    public CompareResultVO proceedGame(String inputNumber) {
        CompareResultVO compareResultVO =
                baseballGameService.compareInputToAnswer(inputNumber, baseballGameService.getAnswerNumberList());
        return setGameResultMessage(compareResultVO);
    }

    private CompareResultVO setGameResultMessage(CompareResultVO compareResultVO) {
        if (compareResultVO.getBallCount() == 0 && compareResultVO.getStrikeCount() == 0) {
            compareResultVO.setGameResultMessage(baseballGameView.nothingCount());
            return compareResultVO;
        }
        String gameResultMessage = baseballGameView.ballCount(compareResultVO.getBallCount())
                + baseballGameView.strikeCount(compareResultVO.getStrikeCount());
        if (compareResultVO.isAllCorrectAnswer()) {
            gameResultMessage += baseballGameView.allCorrectAnswer();
        }
        compareResultVO.setGameResultMessage(gameResultMessage);
        return compareResultVO;
    }

}
