package baseball.view;

import nextstep.utils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public List InputNumberFromUser() {
        System.out.println("숫자를 입력해주세요 : ");
        return Arrays.asList(Console.readLine().split(""));
    }

    public String restartGameByPrompt() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

}
