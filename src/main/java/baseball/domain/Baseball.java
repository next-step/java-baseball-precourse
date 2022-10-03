package baseball.domain;

import java.util.Objects;

public class Baseball {

	private final int baseballNum;
	
	private Baseball(int baseballNum) {
		isValidBaseballNum(baseballNum);
		this.baseballNum = baseballNum;
	}

	private void isValidBaseballNum(int baseballNum) {
		if (baseballNum < 1 || baseballNum > 9) {
			throw new IllegalArgumentException();
		}
	}

	public static Baseball of(int number) {
		return new Baseball(number);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Baseball baseball = (Baseball) o;
		return baseballNum == baseball.baseballNum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(baseballNum);
	}
}
