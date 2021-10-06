package baseball.domain.ball;

import baseball.domain.score.Score;
import baseball.domain.score.ScoreType;
import baseball.exception.BaseballException.DuplicatedBallsException;
import baseball.exception.BaseballException.InvalidBallsLength;

import java.util.*;

import static baseball.constant.Rule.COUNT_OF_BALLS;
import static baseball.domain.score.ScoreType.STRIKE;

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
            balls.add(new Ball(numbers.get(i), START_POSITION + i));
        }
    }

    public Score compare(Balls targetBalls) {
        Score score = new Score();
        for (int i = 0; targetBalls != null && i < targetBalls.getSize(); i++) {
            ScoreType scoreType = getScoreType(targetBalls.getByIndex(i));
            score.put(scoreType);
        }
        return score;
    }

    private ScoreType getScoreType(Ball targetBall) {
        PriorityQueue<ScoreType> scoreTypes = new PriorityQueue<>();
        for (Ball ball : balls) {
            scoreTypes.add(ball.compare(targetBall));
        }
        return scoreTypes.poll();
    }

    private Ball getByIndex(int index) {
        return balls.get(index);
    }

    public int getSize() {
        return balls == null ? 0 : balls.size();
    }

}
