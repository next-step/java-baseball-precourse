package baseball.generator;

import baseball.message.text.TextMessage;
import nextstep.utils.Console;


public class InputGenerator {

    private InputGenerator() {
    }

    /**
     * 플레이어가 숫자를 입력
     * @return
     */
    public static String inputThreeDigits() {
        System.out.print(TextMessage.START);
        return Console.readLine();
    }

}
