package baseball.dto;

import baseball.common.Constants;
import baseball.domain.ScoreBoard;

public class BaseballDTO {

    public static class ResResult {
        private final boolean correct;
        private final int ball;
        private final int strike;

        public ResResult(final ScoreBoard scoreBoard) {
            this.correct = scoreBoard.getStrike() == Constants.LIMIT_DIGITS;
            this.ball = scoreBoard.getBall();
            this.strike = scoreBoard.getStrike();
        }

        public boolean isCorrect() {
            return correct;
        }

        public int getBall() {
            return ball;
        }

        public int getStrike() {
            return strike;
        }
    }
}
