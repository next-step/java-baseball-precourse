package baseball.member;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class User {
    private static final String pattern = "([1-9]{1}[1-9]{1}[1-9]{1})";
    private static final int ZERO = 0;
    private static final int LEN_NUMBERS = 3;

    private List<Integer> numbers = new ArrayList<>();

    public void inputNumbers() {
        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();
        if(isValidNumber(input)) {
            setNumbers(input);
            return;
        }
        throw new IllegalArgumentException("The number entered contains an invalid number.");
    }

    private boolean isValidNumber(String input) {
        return Pattern.matches(pattern, input);
    }

    private void setNumbers(String input) {
        numbers.clear();
        for(int index = ZERO; index < LEN_NUMBERS; index++) {
            numbers.add(Character.getNumericValue(input.charAt(index)));
        }
    }

    public Integer getNumber(int index) {
        return numbers.get(index);
    }
}