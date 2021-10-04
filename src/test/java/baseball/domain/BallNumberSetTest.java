package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BallNumberSetTest {

	@DisplayName("중복되지 않는 3자리 숫자인지 확인")
	@ParameterizedTest
	@ValueSource(strings = {"12", "3456", "44555", "454"})
	void size_invalid(String value) {
		assertThatThrownBy(() -> BallNumberSet.of(value))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("중복되지 않는 3자리 수를 입력해야 합니다.");
	}
}