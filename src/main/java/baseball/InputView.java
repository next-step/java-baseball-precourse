package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
        throw new IllegalStateException("생성자가 필요 없는 클래스입니다.");
    }

    public static String show() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static String showOptions() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}
