package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInputReader implements InputReader {
    @Override
    public List<Integer> readBallNumber() {
        String input = Console.readLine();
        return toNumbers(input);
    }

    private List<Integer> toNumbers(String stringNumbers) {
        List<Integer> result = new ArrayList<>();
        for (String stringNumber: stringNumbers.split("")) {
            result.add(parseInt(stringNumber));
        }
        return result;
    }

    private Integer parseInt(String stringNumber) {
        try {
            return Integer.parseInt(stringNumber);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }
}
