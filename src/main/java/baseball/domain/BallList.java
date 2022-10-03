package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BallList {
	private final List<Ball> ballList = new ArrayList<>();

	public BallList(List<Integer> generateBallList) {
		for (int i = 0; i < generateBallList.size(); i++) {
			this.ballList.add(new Ball.Builder()
				.position(i)
				.value(generateBallList.get(i))
				.build());
		}
	}

	public List<Ball> getBallList() {
		return this.ballList;
	}

	public int strikeBallCount(BallList ballList) {
		int strikeCount = 0;

		for (Ball ball : ballList.getBallList()) {
			strikeCount += isStrike(ball);
		}

		return strikeCount;
	}

	private int isStrike(Ball ball) {
		int strikeBall = 0;

		for (Ball computerBall : this.ballList) {
			strikeBall += computerBall.isStrike(ball) ? 1 : 0;
		}

		return strikeBall;
	}

	public int ballBallCount(BallList ballList) {
		int ballCount = 0;

		for (Ball ball : ballList.getBallList()) {
			ballCount += isBall(ball);
		}

		return ballCount;
	}

	private int isBall(Ball ball) {
		int ballBall = 0;

		for (Ball computerBall : this.ballList) {
			ballBall += computerBall.isBall(ball) ? 1 : 0;
		}

		return ballBall;
	}

	public GameResult ballCount(BallList ballList) {
		return new GameResult.Builder()
			.strike(strikeBallCount(ballList))
			.ball(ballBallCount(ballList))
			.build();
	}
}
