package baseball.domain.ball;

import baseball.exception.BaseballException.DuplicatedBallsException;
import baseball.exception.BaseballException.InvalidBallsLength;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static baseball.constant.Rule.COUNT_OF_BALLS;

public class Balls {

    private static final Integer START_POSITION = 1;
    private List<Ball> balls = new ArrayList<>();

    private Balls(List<Integer> numbers) {
        setBalls(numbers);
    }

    public static Balls valueOf(List<Integer> numbers) {
        validateLength(numbers);
        List<Integer> removedDuplicationNumbers = removeDuplication(numbers);
        validateDuplication(numbers, removedDuplicationNumbers);
        return new Balls(removedDuplicationNumbers);
    }

    private static List<Integer> removeDuplication(List<Integer> numbers) {
        Set<Integer> removedDuplicationNumbers = new LinkedHashSet<>();
        for (Integer number : numbers) {
            removedDuplicationNumbers.add(number);
        }
        return new ArrayList<>(removedDuplicationNumbers);
    }

    private static void validateLength(List<Integer> numbers) {
        if (numbers == null || numbers.size() != COUNT_OF_BALLS) {
            throw new InvalidBallsLength();
        }
    }

    private static void validateDuplication(List<Integer> numbers, List<Integer> removeDuplicationNumbers) {
        if (numbers.size() > removeDuplicationNumbers.size()) {
            throw new DuplicatedBallsException();
        }
    }

    private void setBalls(List<Integer> numbers) {
        for (int i = 0; i < COUNT_OF_BALLS; i++) {
            balls.add(new Ball(numbers.get(i), START_POSITION+i));
        }
    }

    public List<Ball> getValue() {
        return balls;
    }

    public int getSize() {
        return balls == null ? 0 : balls.size();
    }

}
