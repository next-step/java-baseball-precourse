package baseball.service;

import baseball.common.Constants;
import baseball.domain.BallCount;
import baseball.domain.BaseballGame;
import baseball.utils.RandomNumberGenerator;
import baseball.view.InputProvider;

import java.util.List;

public class BaseballGameService {
    private BaseballGame baseballGame;

    public void initGame() {
        List<Integer> computerBalls = RandomNumberGenerator.generateUniqueRandomNumbers(Constants.RANGE_START, Constants.RANGE_END, Constants.NUMBER_SIZE);
        baseballGame = new BaseballGame(computerBalls);
    }

    public void playGame() {
        BallCount result;
        do {
            String inputNumbers = InputProvider.requestInput();
            result = baseballGame.play(inputNumbers);
        } while (!result.isFinish());
    }
}
