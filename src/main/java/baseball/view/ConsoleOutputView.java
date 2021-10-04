package baseball.view;

import baseball.enums.MessageEnum;

public class ConsoleOutputView extends PrintView{

    public void printRoundResult(int strike, int ball) {
        printStrike(strike);
        printBall(ball);
        printNothing(strike, ball);
    }

    public void printRoundOver() {
        super.printNewLine();
        super.printMessage(MessageEnum.ROUND_OVER_MESSAGE.getMessage());
    }

    private void printStrike(int strike) {
        if (strike != 0) {
            super.printInlineMessage(strike + MessageEnum.STRIKE.getMessage());
        }
    }

    private void printBall(int ball) {
        if (ball != 0) {
            super.printMessage(ball + MessageEnum.BALL.getMessage());
        }
    }

    private void printNothing(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            super.printMessage(MessageEnum.NOTHING.getMessage());
        }
    }


}
