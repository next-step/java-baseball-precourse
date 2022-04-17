package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.message.InputMessage;

public class InputView {
    public static String inputNumber() {
        System.out.println(InputMessage.INPUT_NUMBERS_MESSAGE);
        return readLine();
    }
}
