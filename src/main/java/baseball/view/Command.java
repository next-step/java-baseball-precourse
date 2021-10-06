package baseball.view;

import nextstep.utils.Console;

public class Command {

    public String askPlayerNumbers(){
        System.out.print("숫자를 입력해주세요: ");
        return Console.readLine();
    }

    public void printNoting() {
        System.out.print("낫싱");
    }

    public void getStrikeMessage(int strike) {
        System.out.printf("%d스트라이크 ", strike);
    }

    public void getBallMessage(int ball) {
        System.out.printf("%d볼 ", ball);
    }

    public void printError() {
        System.out.println("[ERROR]");
    }

    public void printGameClear() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    public int askContinueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(Console.readLine());
    }

    public void println(){
        System.out.println();
    }
}
