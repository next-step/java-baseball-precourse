package baseball.model;

import java.util.Objects;

public class Ball {

	private final int number;

	private Ball(int number) {
		validate(number);
		this.number = number;
	}

	public static Ball valueOf(int number) {
		return new Ball(number);
	}

	private void validate(int number) {
		if (number < 1 || number > 9) {
			throw new IllegalArgumentException("공을 생성할 수 없는 번호입니다.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Ball ball = (Ball)o;
		return number == ball.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
