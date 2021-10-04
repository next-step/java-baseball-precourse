package baseball.view;

import nextstep.utils.Console;

public class Command {
    private static final int START_GAME_NUM = 1;
    private static final int END_GAME_NUM = 1;

    private final Console console;

    public Command(Console console) {
        this.console = console;
    }

    public String askPlayerNumbers(){
        System.out.print("숫자를 입력해주세요: ");
        return Console.readLine();
    }

    public void printCount(int ball, int strike) {
        if(strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }
        String countMessage =
                getStrikeMessage(strike) +
                getBallMessage(ball);

        System.out.println(countMessage);
    }

    private String getStrikeMessage(int strike) {
        if(strike == 0) {
            return "";
        }
        return String.format("%d스트라이크 ", strike);
    }

    private String getBallMessage(int ball) {
        if(ball == 0) {
            return "";
        }
        return String.format("%d볼 ", ball);
    }

    public void printError() {
        System.out.println("[ERROR]");
    }

    public void printGameClear() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    public int askContinueGame() {
        System.out.println(String.format("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.", START_GAME_NUM, END_GAME_NUM));
        return Integer.parseInt(Console.readLine());
    }
}
