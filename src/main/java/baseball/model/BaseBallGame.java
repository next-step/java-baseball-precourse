package baseball.model;

import java.util.*;

public class BaseBallGame {
    private final Balls rightAnswer;

    public BaseBallGame(List<Integer> numbers) {
        validateDuplicateNumber(numbers);
        this.rightAnswer = new Balls(numbers);
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);

        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("숫자 야구의 정답은 중복되지 않은 서로 다른 수로 이루어져야 합니다");
        }
    }

    public CompareResult tryCompare(String input) {
        List<Integer> numbers = convertStringToIntegerList(input);
        return rightAnswer.compareWith(numbers);
    }

    private List<Integer> convertStringToIntegerList(String s) {
        List<Integer> list = new ArrayList<>();

        for (char c : s.toCharArray()) {
            int number = Character.getNumericValue(c);
            list.add(number);
        }

        return list;
    }
}
