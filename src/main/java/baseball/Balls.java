package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

	private List<Ball> balls;

	public Balls(List<Integer> input) {
		this.balls = mapToBallList(input);
	}

	private List<Ball> mapToBallList(List<Integer> input) {
		List<Ball> balls = new ArrayList<>();

		for (int i = 0; i < input.size(); i++) {
			balls.add(new Ball(input.get(i), i));
		}
		return balls;
	}

	public GameResult play(Balls userBalls) {

		GameResult result = new GameResult();
		for (Ball ball : balls) {
			for (Ball userBall : userBalls.getBalls()) {
				result.recordScore(ball.match(userBall));
			}
		}
		return result;
	}

	public List<Ball> getBalls() {
		return this.balls;
	}
}
