package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {

	@DisplayName("숫자 값이 1 ~ 9인지 검증")
	@Test
	void isValidNo() {
		assertThatThrownBy(() -> Ball.of(10))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("1~9까지의 숫자만 입력 가능합니다.");
	}
}
