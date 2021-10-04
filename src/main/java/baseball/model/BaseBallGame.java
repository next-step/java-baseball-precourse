package baseball.model;

import baseball.model.enums.AnswerStatus;

import java.util.*;

public class BaseBallGame {
    private final Balls rightAnswer;
    private AnswerStatus answerStatus;

    public BaseBallGame(List<Integer> numbers) {
        validateDuplicateNumber(numbers);
        this.rightAnswer = new Balls(numbers);
        this.answerStatus = AnswerStatus.WRONG;
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);

        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("숫자 야구의 정답은 중복되지 않은 서로 다른 수로 이루어져야 합니다");
        }
    }

    public boolean isWrongAnswer() {
        return answerStatus.isWrong();
    }

    public boolean isRightAnswer() {
        return answerStatus.isRight();
    }

    public CompareResult tryCompare(String input) {
        List<Integer> numbers = convertStringToIntegerList(input);
        CompareResult result = rightAnswer.compareWith(numbers);

        if (result.isStrike()) {
            answerStatus = AnswerStatus.RIGHT;
        }

        return result;
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
