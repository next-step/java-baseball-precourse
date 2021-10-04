package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.domain.BallNumber;

public class BallNumberTest {

	@DisplayName("숫자 값이 1 ~ 9인지 검증")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
	void validNo_1_9(int number) {
		assertThat(BallNumber.validNo(number)).isTrue();
	}

	@DisplayName("숫자 값이 1 ~ 9가 아닌지 검증")
	@Test
	void validNo_NOT_1_9() {
		assertThatThrownBy(() -> BallNumber.of(10))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("1~9까지의 숫자만 입력 가능합니다.");
	}
}
