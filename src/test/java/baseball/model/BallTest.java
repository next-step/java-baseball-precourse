package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("공 테스트")
class BallTest {

	@DisplayName("정상 생성")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
	void create(int number) {
		assertThat(Ball.valueOf(number)).isNotNull();
	}

	@DisplayName("같은 수로 생성한 공은 항상 같은 공으로 취급된다")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
	void create_equality(int number) {
		assertThat(Ball.valueOf(number)).isEqualTo(Ball.valueOf(number));
	}

	@DisplayName("공을 생성하는 수가 1 ~ 9 사이가 아니면 예외발생")
	@ParameterizedTest
	@ValueSource(ints = {0, 10, -1})
	void create_invalid_number_exception(int number) {
		assertThatThrownBy(() -> Ball.valueOf(number))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("공을 생성할 수 없는 번호입니다.");
	}
}