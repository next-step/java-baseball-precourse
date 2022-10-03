package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    public static String scanDigits() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }

    public static int scanCommand() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(readLine());
    }
}
