package NumberBaseball.view;

import java.util.Scanner;

public class NumberBaseballView {

    public String displayRound() {
        System.out.print(ViewMessage.INPUT_NUMBER);
        return getInput();
    }

    private static String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void displayResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println(ViewMessage.NOTHING);
            return;
        }

        String result = "";
        if (strike > 0) result += strike + ViewMessage.STRIKE + " ";
        if (ball > 0) result += ball + ViewMessage.BALL;
        System.out.println(result);
    }

    public String displayRestart() {
        System.out.println(ViewMessage.GAME_END);
        System.out.println(ViewMessage.RESTART);
        return getInput();
    }

    public void displayErrorMessage(String message) {
        System.out.println(message);
    }
}
