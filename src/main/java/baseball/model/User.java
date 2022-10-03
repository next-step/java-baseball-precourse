package baseball.model;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> numbers;

    public void inputNumber() {
        String input = Console.readLine();
        validateInput(input);
        addNumberToList(input);
    }

    private void validateInput(String input) {
        try {
            int parseInt = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 이루어진 문자만 입력할 수 있습니다.");
        }
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력한 숫자는 정해진 범위를 초과했습니다.");
        }
    }

    private void addNumberToList(String input) {
        numbers = new ArrayList<>();
        for (String num : input.split("")) {
            numbers.add(Integer.parseInt(num));
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
