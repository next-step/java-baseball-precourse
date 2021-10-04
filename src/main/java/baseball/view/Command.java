package baseball.view;

import nextstep.utils.Console;

public class Command {
    private final Console console;

    public Command(Console console) {
        this.console = console;
    }

    public String askPlayerNumbers(){
        System.out.print("숫자를 입력해주세요: ");
        return Console.readLine();
    }

    public void printCount(int ball, int strike) {
        System.out.println(strike + "스트라이크 " + ball + "볼");
    }

    public void printError() {
        System.out.println("[ERROR]");
    }
}
