package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("GameInput 단위 테스트")
public class GameInputTest {

	@Test
	@DisplayName("길이가 일치하지 않을 경우 예외를 던진다.")
	void test01() {
		assertThatIllegalArgumentException().isThrownBy(() -> new GameInput("1"));
	}

	@Test
	@DisplayName("문자가 중복될 경우 예외를 던진다.")
	void test02() {
		assertThatIllegalArgumentException().isThrownBy(() -> new GameInput("11"));
	}
}
