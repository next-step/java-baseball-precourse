package baseball.model;

import java.util.Objects;

/**
 * 숫자야구게임에서 숫자의 위치가 몇번째인지에 대한 원시값을 포장하는 객체
 */
public class BallPosition {

	private final int position;

	private static final int MIN_BALL_POSITION = 1;
	private static final int MAX_BALL_POSITION = 3;

	public BallPosition(int position) {
		isValidPosition(position);
		this.position = position;
	}

	private void isValidPosition(int position) {
		if (position < MIN_BALL_POSITION || position > MAX_BALL_POSITION) {
			throw new IllegalArgumentException("[ERROR] 공의 위치는 1-3 까지만 가능합니다.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BallPosition that = (BallPosition)o;
		return position == that.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}
}
