package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {

	private final List<Ball> balls;

	private Balls(List<Ball> balls) {
		if (balls.size() != 3) {
			throw new IllegalArgumentException("숫자 3개를 입력 받아야 합니다.");
		}

		Set<Ball> duplicateChecker = new HashSet<>(balls);
		if (duplicateChecker.size() != 3) {
			throw new IllegalArgumentException("중복된 숫자를 입력받을 수 없습니다.");
		}
		this.balls = balls;
	}

	public static Balls of(Integer... numbers) {
		return new Balls(generateBalls(numbers));
	}

	private static List<Ball> generateBalls(Integer... numbers) {
		List<Ball> balls = new ArrayList<>();
		for (Integer number : numbers) {
			balls.add(Ball.valueOf(number));
		}
		return balls;
	}
}
