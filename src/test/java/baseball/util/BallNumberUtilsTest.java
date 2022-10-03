package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.message.ErrorMessage;

class BallNumberUtilsTest {

	private final int BALL_MIN_NO = 1;
	private final int BALL_MAX_NO = 9;
	private final int BALL_COUNT = 3;

	@Test
	@DisplayName("BallNo로 변환한다.")
	void toBallNumber() {
		int ball = BallNumberUtils.toBallNumber("1", BALL_MIN_NO, BALL_MAX_NO);
		assertThat(ball).isGreaterThanOrEqualTo(BALL_MIN_NO).isLessThanOrEqualTo(BALL_MAX_NO);
	}

	@Test
	@DisplayName("문자가 Null 일 경우, 오류를 반환한다.")
	void toBallNumber_FailedByNull() {
		assertThatThrownBy(() -> {
			BallNumberUtils.toBallNumber(null, BALL_MIN_NO, BALL_MAX_NO);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ErrorMessage.INPUT_BALLS_ERROR.toString());
	}

	@ParameterizedTest
	@ValueSource(strings = {"0", "10"})
	@DisplayName("지정한 범위에서 벗어난 숫자일 경우 오류를 반환한다.")
	void toBallNumber_FailedByRangeOver(String input) {
		assertThatThrownBy(() -> {
			BallNumberUtils.toBallNumber(input, BALL_MIN_NO, BALL_MAX_NO);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ErrorMessage.INPUT_BALLS_ERROR.toString());
	}

	@Test
	@DisplayName("숫자가 아닌 경우 오류를 반환한다.")
	void toBallNumber_FailedByNotNumber() {
		assertThatThrownBy(() -> {
			BallNumberUtils.toBallNumber("ㄴ", BALL_MIN_NO, BALL_MAX_NO);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ErrorMessage.INPUT_BALLS_ERROR.toString());
	}

	@Test
	void toBallNumbers() {
		List<Integer> numbers = BallNumberUtils.toBallNumbers("123", BALL_MIN_NO, BALL_MAX_NO, BALL_COUNT);

		assertThat(numbers).hasSize(BALL_COUNT);

		// 중복 값 유무 테스트
		Set<Integer> nonDuplicatedNumbers = new HashSet<>(numbers);
		assertThat(numbers).hasSameSizeAs(nonDuplicatedNumbers);
	}

	@ParameterizedTest
	@ValueSource(strings = {"12", "1234"})
	@DisplayName("문자 개수가 지정한 숫자에 일치하지 않는 경우 오류를 반환한다.")
	void toBallNumbers_FailedByLength(String input) {
		assertThatThrownBy(() -> {
			BallNumberUtils.toBallNumbers(input, BALL_MIN_NO, BALL_MAX_NO, BALL_COUNT);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ErrorMessage.INPUT_BALLS_ERROR.toString());
	}

	@Test
	@DisplayName("중복된 숫자가 있는 경우 오류를 반환한다.")
	void toBallNumber_FailedByDuplicatedNumber() {
		assertThatThrownBy(() -> {
			BallNumberUtils.toBallNumber("112", BALL_MIN_NO, BALL_MAX_NO);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ErrorMessage.INPUT_BALLS_ERROR.toString());
	}
}