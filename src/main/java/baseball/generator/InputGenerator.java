package baseball.generator;

import nextstep.utils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputGenerator {

    private InputGenerator() {
    }

    public static String inputThreeDigits() {
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static List<Integer> convertToIntegerList(String input) {
        final ArrayList<Integer> list = new ArrayList<>();
        for (char c : input.toCharArray()) {
            list.add(Integer.parseInt(String.valueOf(c)));
        }
        return list;
    }
}