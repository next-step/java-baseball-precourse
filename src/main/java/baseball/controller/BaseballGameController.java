package baseball.controller;

import baseball.domain.BaseballNumber;
import baseball.domain.GameState;
import baseball.dto.BaseballGameResultDto;
import baseball.service.BaseballGameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {

    private final BaseballGameService baseballGameService;

    public BaseballGameController(BaseballGameService baseballGameService) {
        this.baseballGameService = baseballGameService;
    }

    public void run() {
        GameState gameState = GameState.PROGRESS;
        while (gameState.isGameProgress()) {
            BaseballNumber computer = BaseballNumber.createRandomNumber();

            playGame(computer);

            gameState = InputView.inputWhetherRestartGame();
        }
    }

    private void playGame(BaseballNumber computer) {
        boolean isFinish = false;
        while (!isFinish) {
            BaseballNumber player = new BaseballNumber(InputView.inputPlayerNumber());

            BaseballGameResultDto baseballGameResultDto = baseballGameService.playGame(computer, player);

            OutputView.printGameResult(baseballGameResultDto);
            isFinish = baseballGameResultDto.isFinishGame();
        }
    }
}
