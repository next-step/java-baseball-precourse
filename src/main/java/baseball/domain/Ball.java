package baseball.domain;

import java.util.Objects;

public class Ball {

	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	private int number;

	private Ball(int number) {
		this.number = number;
	}

	private static boolean isValidNo(int number){
		return number >= MIN_NUMBER && number <= MAX_NUMBER;
	}

	public static Ball of(int number) {
		if(!isValidNo(number)) {
			throw new IllegalArgumentException("1~9까지의 숫자만 입력 가능합니다.");
		}
		return new Ball(number);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Ball that = (Ball)o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}