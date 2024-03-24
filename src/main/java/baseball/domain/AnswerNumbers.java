package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AnswerNumbers {
    private final List<GameNumber> gameNumbers;

    private AnswerNumbers(List<GameNumber> gameNumbers) {
        validate(gameNumbers);
        this.gameNumbers = gameNumbers;
    }

    public static AnswerNumbers from(List<Integer> numbers) {
        List<GameNumber> response = new ArrayList<>();

        for (Integer number : numbers) {
            response.add(GameNumber.create(number));
        }

        return new AnswerNumbers(response);
    }

    public AtBat calculateAtBat(GameNumber number, int index) {
        if (gameNumbers.contains(number) && gameNumbers.indexOf(number) == index) {
            return AtBat.STRIKE;
        }
        if (gameNumbers.contains(number)) {
            return AtBat.BALL;
        }
        return AtBat.NOTHING;
    }

    private void validate(List<GameNumber> gameNumbers) {
        if (gameNumbers.size() != 3) {
            throw new IllegalArgumentException("3자리 게임 숫자가 필요합니다.");
        }
        if (hasDuplication(gameNumbers)) {
            throw new IllegalArgumentException("정답 숫자에 중복된 숫자가 존재해선 안됩니다.");
        }
    }

    private static boolean hasDuplication(List<GameNumber> gameNumbers) {
        return new HashSet<>(gameNumbers).size() != gameNumbers.size();
    }
}
