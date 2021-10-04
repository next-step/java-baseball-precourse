package baseball.domain;

import java.util.Objects;

public class GameResult {

	private final StrikeResult strike;
	private final BallResult ball;

	public GameResult() {
		this(0, 0);
	}

	public GameResult(int strike, int ball) {
		this(new StrikeResult(strike), new BallResult(ball));
	}

	public GameResult(StrikeResult strike, BallResult ball) {
		this.strike = strike;
		this.ball = ball;
	}

	/**
	 * gameStatus 로 하여금 strike 와 ball 의 횟수를 증가시킨다.
	 * Immutable 한 객체로 가져가기 위해 객체에 변화가 있는 경우 새로운 GameResult 를 매번 반환시키도록 한다.
	 *
	 * @param gameStatus 숫자야구 게임의 결과
	 * @return immutable 한 GameResult
	 */
	public GameResult applyGameStatus(GameStatus gameStatus) {
		if (GameStatus.isStrike(gameStatus)) {
			return new GameResult(strike.increase(), ball);
		}
		if (GameStatus.isBall(gameStatus)) {
			return new GameResult(strike, ball.increase());
		}
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		GameResult that = (GameResult)o;
		return Objects.equals(strike, that.strike) && Objects.equals(ball, that.ball);
	}

	@Override
	public int hashCode() {
		return Objects.hash(strike, ball);
	}
}
