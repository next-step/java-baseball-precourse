package baseball.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public String answer() {
        System.out.println("숫자를 입력해 주세요 : ");
        return scanner.next();
    }

    public String gameOver() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.next();
    }
}
