package baseball.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 숫자야구게임의 상대방 혹은 내가 선택한 ball의 리스트를 갖고있는 일급컬렉션 객체
 */
public class Balls {

	private final List<Ball> balls;

	private static final int VALID_BALLS_SIZE = 3;

	public Balls(List<Integer> intBalls) {
		isValidBalls(intBalls);

		balls = new ArrayList<>();
		for (int i = 0; i < intBalls.size(); i++) {
			balls.add(new Ball(intBalls.get(i), i + 1));
		}
	}

	private void isValidBalls(List<Integer> balls) {
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

	/**
	 * 여러개의 공을 갖고있는 Balls 객체와 다른 Balls 을 비교하여 결과를 반환한다.
	 *
	 * @param inputBalls Balls 와 비교할 3개의 공을 가지고있는 Balls
	 * @return 게임을 진행 한 뒤 strike / ball 의 갯수를 갖고있는 GameResult
	 */
	public GameResult play(Balls inputBalls) {
		GameResult gameResult = new GameResult();

		for (Ball ball : balls) {
			gameResult = gameResult.applyGameStatus(inputBalls.play(ball));
		}

		return gameResult;
	}
}
