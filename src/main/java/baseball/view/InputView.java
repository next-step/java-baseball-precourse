package baseball.view;

import baseball.utils.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String EXIT_MESSAGE  = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final Validator validator = new Validator();

    public static String inputNumber() {
        System.out.print(INPUT_MESSAGE);
        String input = Console.readLine();
        validator.validInputNumber(input);
        return input;
    }

    public static String inputExit() {
        System.out.println(EXIT_MESSAGE);
        String input = Console.readLine();
        validator.validExit(input);
        return input;
    }
}
