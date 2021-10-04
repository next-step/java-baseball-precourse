package baseball.generator;

import baseball.message.text.TextMessage;
import nextstep.utils.Console;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 문자열을 정수 리스트로 변환
     * @param input
     * @return
     */
    public static List<Integer> convertToIntegerList(String input) {
        final ArrayList<Integer> list = new ArrayList<>();
        for (char c : input.toCharArray()) {
            list.add(Integer.parseInt(String.valueOf(c)));
        }
        return list;
    }
}