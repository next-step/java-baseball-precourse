package baseball.model;

import java.util.Objects;

import baseball.constant.CommonConstants;

/**
 * 숫자야구게임의 결과 중, 볼의 갯수에 대해서 원시값을 포장하는 객체
 */

public class BallResult {

	private final int ballCount;

	private static final int MIN_BALL_COUNT = 0;
	private static final int MAX_BALL_COUNT = 3;

	public BallResult() {
		this(0);
	}

	public BallResult(int ballCount) {
		isValidBall(ballCount);
		this.ballCount = ballCount;
	}

	private void isValidBall(int ballCount) {
		if (ballCount < MIN_BALL_COUNT || ballCount > MAX_BALL_COUNT) {
			throw new IllegalArgumentException("[ERROR] ball 이 될 수 있는 값은 0-3 범위 내여야 합니다.");
		}
	}

	/**
	 * ball 의 갯수를 한개 증가시킨 후 새로운 immutable 하게 구현하기 위해 새로운 Ball 객체를 반환한다.
	 *
	 * @return 기존의 Ball 객체에서 ballCount 가 한개 증가된 Ball 객체
	 */
	public BallResult increase() {
		final int ballCount = this.ballCount + 1;
		isValidBall(ballCount);

		return new BallResult(ballCount);
	}

	@Override
	public String toString() {
		if (ballCount != 0) {
			return ballCount + GameStatus.BALL.getDescription();
		}
		return CommonConstants.EMPTY_STRING;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BallResult that = (BallResult)o;
		return ballCount == that.ballCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ballCount);
	}
}
