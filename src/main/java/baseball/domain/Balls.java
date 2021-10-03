package baseball.domain;

import java.util.List;

public class Balls {

	private static final int VALID_BALLS_SIZE = 3;
	private final List<Ball> balls;

	public Balls(List<Ball> balls) {
		isValidBalls(balls);
		this.balls = balls;
	}

	private void isValidBalls(List<Ball> balls) {
		if (balls.isEmpty() || balls.size() != VALID_BALLS_SIZE) {
			throw new IllegalArgumentException("[ERROR] 숫자야구 게임을 하기위해서는 3개의 공이 필요합니다.");
		}
	}

	/**
	 * 여러개의 공을 갖고있는 Balls 객체와 한개의 Ball 을 비교하여 결과를 반환한다.
	 *
	 * @param inputBall Balls 와 비교할 하나의 Ball
	 * @return 비교 한 이후 GameStatus
	 */
	public GameStatus play(Ball inputBall) {
		GameStatus gameStatus = GameStatus.NOTHING;

		for (Ball ball : balls) {
			gameStatus = GameStatus.changeStatus(gameStatus, ball.play(inputBall));
		}

		return gameStatus;
	}
}
