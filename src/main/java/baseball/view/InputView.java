package baseball.view;

import baseball.domain.BaseballNumber;
import nextstep.utils.Console;

public class InputView {
    public BaseballNumber inputAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        try {
            BaseballNumber baseballNumber = new BaseballNumber(Console.readLine());
            return baseballNumber;
        } catch (IllegalArgumentException iae) {
            return inputAnswer();
        }
    }

    public boolean inputReGameFlag() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            return inputToBoolean(Console.readLine());
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return inputReGameFlag();
        }
    }

    private boolean inputToBoolean(String input) {
        if ("1".equals(input)) {
            return true;
        }
        if ("2".equals(input)) {
            return false;
        }
        throw new IllegalArgumentException("[ERROR] 1이나 2를 입력해주세요.");
    }
}
