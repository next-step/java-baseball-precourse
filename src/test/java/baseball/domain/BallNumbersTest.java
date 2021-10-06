package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BallNumbersTest {

	@DisplayName("중복되지 않는 3자리 숫자인지 확인")
	@ParameterizedTest
	@ValueSource(strings = {"12", "3456", "44555", "454", "d"})
	void isValidSize_test(String value) {
		assertThatThrownBy(() -> BallNumbers.of(value))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("중복되지 않는 3자리 수를 입력해야 합니다.");
	}

	@DisplayName("입력 값이 숫자인지 확인")
	@ParameterizedTest
	@ValueSource(strings = {"abc", "1dc"})
	void isValidNo_test(String value) {
		assertThatThrownBy(() -> BallNumbers.of(value))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("숫자가 아닙니다.");
	}

	@DisplayName("포함여부 확인")
	@Test
	void isContains_test() {
		assertThat(BallNumbers.of("123").isContains(Ball.of(1))).isTrue();
		assertThat(BallNumbers.of("123").isContains(Ball.of(4))).isFalse();
	}

	@DisplayName("같은 위치에 같은 값인지 확인")
	@Test
	void isEqualFromIndex_test() {
		assertThat(BallNumbers.of("123").isEqualFromIndex(Ball.of(1), 0)).isTrue();
		assertThat(BallNumbers.of("123").isEqualFromIndex(Ball.of(1), 1)).isFalse();
	}
}