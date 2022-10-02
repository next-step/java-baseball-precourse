package baseball.dto;

import baseball.domain.BaseballNumber;
import baseball.domain.GameResult;

public class BaseballGameResultDto {

    private final int strike;
    private final int ball;

    public BaseballGameResultDto(GameResult gameResult) {
        strike = gameResult.getStrike();
        ball = gameResult.getBall();
    }

    public boolean isFinishGame() {
        return strike == BaseballNumber.NUMBER_COUNT;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
