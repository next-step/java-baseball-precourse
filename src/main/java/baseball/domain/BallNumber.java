package baseball.domain;

import java.util.Objects;

/**
 * 숫자야구게임의 숫자를 래핑하는 객체
 */
public class BallNumber {

	private final int number;

	private static final int MIN_BALL_NUMBER = 1;
	private static final int MAX_BALL_NUMBER = 9;

	public BallNumber(int number) {
		isValidNumber(number);
		this.number = number;
	}

	private void isValidNumber(int number) {
		if (number < MIN_BALL_NUMBER || number > MAX_BALL_NUMBER) {
			throw new IllegalArgumentException("[ERROR] 1-9 까지의 숫자만 입력가능합니다.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BallNumber that = (BallNumber)o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
