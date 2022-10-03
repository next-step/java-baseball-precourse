package baseball.game.ui.console.input;

import camp.nextstep.edu.missionutils.Console;

public class InputConsole {
    public static char[] read() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validate(input);
        return input.toCharArray();
    }

    private static void validate(String input) {
        validateInputLength(input);
        validateInputNumber(input);
    }

    private static void validateInputNumber(String input) {
        if (!input.matches("^[1-9]+$")) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private static void validateInputLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리로 입력해주세요");
        }
    }

    public static boolean askRestart() {
        System.out.println("게임을 새로 시작하려면 1 종료하려면 2를 입력하세요");
        String answer = Console.readLine();
        return Integer.parseInt(answer) == 1;
    }
}
