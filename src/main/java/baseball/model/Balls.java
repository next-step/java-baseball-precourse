package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Balls {
	private final List<Ball> answers;

	public Balls(List<Integer> numbers) {
		this.answers = mapBall(numbers);
	}

	private static List<Ball> mapBall(List<Integer> numbers) {
		List<Ball> balls = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			balls.add(new Ball(i + 1, numbers.get(i)));
		}
		return balls;
	}

	public BallStatus play(Ball userBall) {
		for (Ball answer : answers) {
			BallStatus status = answer.play(userBall);
			if (status == BallStatus.STRIKE) {
				return BallStatus.STRIKE;
			} else if (status == BallStatus.BALL) {
				return BallStatus.BALL;
			}
		}
		return BallStatus.NOTHING;
	}

	public PlayResult play(List<Integer> balls) {
		Balls userBalls = new Balls(balls);
		PlayResult result = new PlayResult();
		for (Ball answer : answers) {
			BallStatus status = userBalls.play(answer);
			result.report(status);
		}
		return result;
	}
}
