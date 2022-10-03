package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String numberInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        System.out.print("[ERROR] 유효한 숫자를 입력해주세요 : ");
        return numberInput();
    }

    public static String restartInput() {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        System.out.println("[ERROR] 유효한 숫자를 입력해주세요 : ");
        return restartInput();
    }

}
