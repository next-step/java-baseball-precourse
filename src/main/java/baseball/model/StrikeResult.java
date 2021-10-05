package baseball.model;

import java.util.Objects;

import baseball.constant.CommonConstants;

/**
 * 숫자야구게임의 결과 중, 스타라이크 갯수에 대해서 원시값을 포장하는 객체
 */

public class StrikeResult {

	private final int strikeCount;

	private static final int MIN_STRIKE_COUNT = 0;
	private static final int MAX_STRIKE_COUNT = 3;

	public StrikeResult() {
		this(0);
	}

	public StrikeResult(int strikeCount) {
		isValidStrike(strikeCount);
		this.strikeCount = strikeCount;
	}

	private void isValidStrike(int strikeCount) {
		if (strikeCount < MIN_STRIKE_COUNT || strikeCount > MAX_STRIKE_COUNT) {
			throw new IllegalArgumentException("[ERROR] strike 할 수 있는 값은 0-3 범위 내여야 합니다.");
		}
	}

	/**
	 * strike 의 갯수를 한개 증가시킨 후 새로운 immutable 하게 구현하기 위해 Strike 객체를 반환한다.
	 *
	 * @return 기존의 Strike 객체에서 strike 가 한개 증가된 Strike 객체
	 */
	public StrikeResult increase() {
		final int strikeCount = this.strikeCount + 1;
		isValidStrike(strikeCount);

		return new StrikeResult(strikeCount);
	}

	public boolean isNotFinished() {
		return strikeCount != MAX_STRIKE_COUNT;
	}

	@Override
	public String toString() {
		if (strikeCount != 0) {
			return strikeCount + GameStatus.STRIKE.getDescription();
		}
		return CommonConstants.EMPTY_STRING;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		StrikeResult that = (StrikeResult)o;
		return strikeCount == that.strikeCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(strikeCount);
	}
}
