package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("GameInput 단위 테스트")
public class GameInputTest {

	@Nested
	@DisplayName("GameInput 생성")
	class GameInputConstructor_UnitTest {
		@Test
		@DisplayName("길이가 일치하지 않을 경우 예외를 던진다.")
		void checkSize () {
			assertThatIllegalArgumentException().isThrownBy(() -> new GameInput("1"));
		}

		@Test
		@DisplayName("문자가 중복될 경우 예외를 던진다.")
		void checkDuplication () {
			assertThatIllegalArgumentException().isThrownBy(() -> new GameInput("11"));
		}

		@Test
		@DisplayName("GameInput을 생성한다.")
		void createGameInput() {
			// given
			final String input = "234";

			// when
			final GameInput gameInput = new GameInput(input);

			// then
			assertThat(gameInput.getValues()).containsExactly(2,3,4);
		}
	}
}
