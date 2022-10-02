package baseball.view;

import baseball.contant.BaseballMessage;
import baseball.domain.referee.Hint;

public class BaseballView {

    public void printJudgement(Hint hint) {
        printStrike(hint);
        printBallAndStrike(hint);
        printBall(hint);
        printNothing(hint);
    }

    private void printStrike(Hint hint) {
        if (hint.getStrike() != 0 && hint.getBall() == 0) {
            System.out.printf((BaseballMessage.STRIKE) + "%n", hint.getStrike());
        }
    }

    private void printBallAndStrike(Hint hint) {
        if (hint.getStrike() != 0 && hint.getBall() != 0) {
            System.out.printf((BaseballMessage.BALL_AND_STRIKE) + "%n", hint.getBall(), hint.getStrike());
        }
    }

    private void printBall(Hint hint) {
        if (hint.getStrike() == 0 && hint.getBall() != 0) {
            System.out.printf((BaseballMessage.BALL) + "%n", hint.getBall());
        }
    }

    private void printNothing(Hint hint) {
        if (hint.getStrike() == 0 && hint.getBall() == 0) {
            System.out.println(BaseballMessage.NOTHING);
        }
    }

    public void printContinue() {
        System.out.println(BaseballMessage.GAME_END);
        System.out.println(BaseballMessage.CONTINUE);
    }
}
