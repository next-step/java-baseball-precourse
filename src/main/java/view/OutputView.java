package view;


import domain.baseball.Hint;

import static domain.baseball.constants.HintType.*;

public class OutputView {

    static {
        System.out.println("숫자 야구 게임을 시작한다.");
    }
    public void displayInputNumbers (){
        System.out.print("숫자 3개를 입력하슈 : ");
    }

    public void displayCorrectAnswer() {
        System.out.println("3개의 숫자를 모두 맞췄다.");
    }

    public void displaySelect() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력해라.");
    }

    public void printError() {
        System.out.println("잘못된 입력이다. 다음 조건에 맞춰서 입력해라");
    }

    public void displayHint(Hint hint) {
        if (hint == null) {
            printError();
            return;
        }
        if (hint.isNothing()) {
            System.out.println(NOTHING.getName());
            return;
        }
        if (hint.getStrike() != 0) {
            System.out.print(hint.getStrike() + STRIKE.getName()+" ");
        }
        if (hint.getBall() != 0) {
            System.out.print(hint.getBall() + BALL.getName());
        }
        System.out.println();
    }
}
