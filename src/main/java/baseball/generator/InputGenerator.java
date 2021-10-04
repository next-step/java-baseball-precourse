package baseball.generator;

import nextstep.utils.Console;

public class InputGenerator {

    private InputGenerator() {
    }

    public static String inputThreeDigits() {
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }
}