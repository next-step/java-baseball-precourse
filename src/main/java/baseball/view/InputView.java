package baseball.view;

import baseball.domain.BaseballNumber;
import nextstep.utils.Console;

public class InputView {
    public BaseballNumber inputAnswer() {
        System.out.println("숫자를 입력해주세요 : ");
        try {
            BaseballNumber baseballNumber = new BaseballNumber(Console.readLine());
            return baseballNumber;
        } catch (IllegalArgumentException iae) {
            return inputAnswer();
        }
    }
}
