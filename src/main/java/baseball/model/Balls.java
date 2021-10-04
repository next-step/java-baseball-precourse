package baseball.model;

import static baseball.model.BallStatus.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {

	private static final int BALLS_SIZE = 3;
	private static final int START_INDEX = 0;
	private static final int NOTHING_INDEX = -1;

	private final List<Ball> balls;

	private Balls(List<Ball> balls) {
		if (balls.size() != BALLS_SIZE) {
			throw new IllegalArgumentException("숫자 3개를 입력 받아야 합니다.");
		}

		Set<Ball> duplicateChecker = new HashSet<>(balls);
		if (duplicateChecker.size() != BALLS_SIZE) {
			throw new IllegalArgumentException("중복된 숫자를 입력받을 수 없습니다.");
		}
		this.balls = balls;
	}

	public static Balls of(List<Integer> numbers) {
		return new Balls(generateBalls(numbers));
	}

	public static Balls of(Integer... numbers) {
		return Balls.of(Arrays.asList(numbers));
	}

	private static List<Ball> generateBalls(Collection<Integer> numbers) {
		List<Ball> balls = new ArrayList<>();
		for (Integer number : numbers) {
			balls.add(Ball.valueOf(number));
		}
		return balls;
	}

	public BallCount match(Balls targets) {
		List<BallStatus> statuses = new ArrayList<>();

		for (int sourceIndex = START_INDEX; sourceIndex < this.balls.size(); sourceIndex++) {
			final int targetIndex = targets.balls.indexOf(this.balls.get(sourceIndex));
			statuses.add(matchStatus(sourceIndex, targetIndex));
		}

		return BallCount.from(statuses);
	}

	private BallStatus matchStatus(int sourceIndex, int targetIndex) {
		if (targetIndex == sourceIndex) {
			return STRIKE;
		}
		if (targetIndex == NOTHING_INDEX) {
			return NOTHING;
		}

		return BALL;
	}
}
