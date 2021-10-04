package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("공의 모음 테스트")
class BallsTest {

	@DisplayName("외부로부터 3개의 값을 받아서 생성한다")
	@Test
	void create() {
		assertThat(Balls.of(1, 2, 3)).isNotNull();
	}

	@DisplayName("3개의 숫자가 중복되면 예외발생")
	@ParameterizedTest
	@CsvSource(value = {"1,2,2", "3,4,4", "1,1,1", "2,4,2", "1,1,4"}, delimiter = ',')
	void create_duplicate_number_exception(int first, int second, int third) {
		assertThatThrownBy(() -> Balls.of(first, second, third))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("중복된 숫자를 입력받을 수 없습니다.");
	}

	@DisplayName("입력된 숫자가 3자리수가 아니면 예외발생")
	@Test
	void create_length_check_exception() {
		assertThatThrownBy(Balls::of)
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("숫자 3개를 입력 받아야 합니다.");

		assertThatThrownBy(() -> Balls.of(1))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("숫자 3개를 입력 받아야 합니다.");

		assertThatThrownBy(() -> Balls.of(1, 2))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("숫자 3개를 입력 받아야 합니다.");

		assertThatThrownBy(() -> Balls.of(1, 2, 3, 4))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("숫자 3개를 입력 받아야 합니다.");
	}
}