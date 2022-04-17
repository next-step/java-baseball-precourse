package baseball.view;

import baseball.common.Constants;
import baseball.dto.BaseballDTO;

public class BaseBallView {
    public void printInput() {
        System.out.print("숫자를 입력해주세요: ");
    }

    public void printScore(final BaseballDTO.ResResult result) {
        final int ball = result.getBall();
        final int strike = result.getStrike();

        printBall(ball);
        printStrike(strike);
        printNothing(ball, strike);
        System.out.println();
    }

    private void printBall(final int ball) {
        if (ball > 0) {
            System.out.printf("%d볼 ", ball);
        }
    }

    private void printStrike(final int strike) {
        if (strike > 0) {
            System.out.printf("%d스트라이크", strike);
        }
    }

    private void printNothing(final int ball, final int strike) {
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
    }

    public void printReGame() {
        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", Constants.LIMIT_DIGITS);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
