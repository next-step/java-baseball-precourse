package baseball.model;

import java.util.Objects;

/**
 * 숫자야구게임의 결과 중, 스타라이크 갯수에 대해서 원시값을 포장하는 객체
 */
public class Ball {

	private final BallNumber number;
	private final BallPosition position;

	public Ball(int number, int position) {
		this.number = new BallNumber(number);
		this.position = new BallPosition(position);
	}

	/**
	 * 컴퓨터 공과 유저의 공을 비교하여 Strike / Ball / Nothing 의 결과를 반환한다.
	 *
	 * @param playerBall 번호와 상태를 갖고있는 Ball
	 * @return 숫자와 위치가 같은경우 Strike, 숫자만 같은경우 Ball, 숫자가 다른경우 Nothing 을 반환한다.
	 */
	public GameStatus play(Ball playerBall) {
		if (playerBall.equals(this)) {
			return GameStatus.STRIKE;
		}

		if (playerBall.isSameNumber(number)) {
			return GameStatus.BALL;
		}

		return GameStatus.NOTHING;
	}

	private boolean isSameNumber(BallNumber number) {
		return number.equals(this.number);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Ball ball = (Ball)o;
		return Objects.equals(number, ball.number) && Objects.equals(position, ball.position);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, position);
	}
}
