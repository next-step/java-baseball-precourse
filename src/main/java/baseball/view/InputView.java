package baseball.view;

import baseball.domain.Option;
import nextstep.utils.Console;

public class InputView {

    public String getUserInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();
        return inputNumber;
    }

    public Boolean isReStart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String option = Console.readLine();
        return Option.of(option).isReStart();
    }


}
