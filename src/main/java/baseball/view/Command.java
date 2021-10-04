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
        StringBuilder countMessage = new StringBuilder();
        countMessage.append(strikeCountCheck(strike));
        countMessage.append(ballCountCheck(ball));
        if(countMessage.length() == 0) {
            System.out.println("낫싱");
        }
        System.out.println(countMessage);
    }

    private String strikeCountCheck(int strike) {
        StringBuilder countMessage = new StringBuilder();
        if(strike > 0) {
            countMessage.append(strike).append("스트라이크 ");
        }
        return countMessage.toString();
    }

    private String ballCountCheck(int ball) {
        StringBuilder countMessage = new StringBuilder();
        if(ball > 0) {
            countMessage.append(ball).append("볼");
        }
        return String.valueOf(countMessage);
    }

    public void printError() {
        System.out.println("[ERROR]");
    }

}
