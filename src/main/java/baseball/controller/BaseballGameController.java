package baseball.controller;

import baseball.common.Constants;
import baseball.service.BaseballGameService;
import baseball.view.InputProvider;
import baseball.view.OutputProvider;

import java.util.Objects;

public class BaseballGameController {

    private final BaseballGameService baseballGameService = new BaseballGameService();

    public void run() {
        this.initGame();
        this.playGame();
        this.endBaseball();
        this.retryBaseball();
    }

    private void initGame() {
        baseballGameService.initGame();
    }

    private void playGame() {
        baseballGameService.playGame();
    }

    private void endBaseball() {
        OutputProvider.printFinishGame();
    }

    private void retryBaseball() {
        OutputProvider.printRetryOption();
        if (Objects.equals(InputProvider.retryOptionInput(), Constants.OPT_RETRY)) {
            this.run();
        }
    }
}
