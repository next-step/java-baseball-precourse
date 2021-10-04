package baseball.model;

import static baseball.model.BallStatus.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

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

	@DisplayName("같은 수가 같은자리에 3개 있으면 3스트라이크")
	@ParameterizedTest
	@CsvSource(value = {"1,2,3", "4,5,6", "2,3,5"}, delimiter = ',')
	void three_strike(int first, int second, int third) {
		final Balls question = Balls.of(first, second, third);
		final Balls answer = Balls.of(first, second, third);

		List<BallStatus> status = question.match(answer);

		assertThat(status.size()).isEqualTo(3);
		assertThat(status).containsExactly(STRIKE, STRIKE, STRIKE);
	}

	@DisplayName("같은 수가 같은자리에 2개 있으면 2스트라이크 1낫씽")
	@ParameterizedTest
	@CsvSource(value = {"2,4,3", "2,5,8", "1,4,8"}, delimiter = ',')
	void two_strike(int first, int second, int third) {
		final Balls question = Balls.of(first, second, third);
		final Balls answer = Balls.of(2, 4, 8);

		List<BallStatus> status = question.match(answer);

		assertThat(status.size()).isEqualTo(3);
		assertThat(status).containsExactlyInAnyOrder(STRIKE, STRIKE, NOTHING);
	}

	@DisplayName("같은 수가 같은자리에 1개 있으면 1스트라이크 2낫씽")
	@ParameterizedTest
	@CsvSource(value = {"2,4,3", "1,9,7", "1,4,8"}, delimiter = ',')
	void one_strike(int first, int second, int third) {
		final Balls question = Balls.of(first, second, third);
		final Balls answer = Balls.of(2, 9, 8);

		List<BallStatus> status = question.match(answer);

		assertThat(status.size()).isEqualTo(3);
		assertThat(status).containsExactlyInAnyOrder(STRIKE, NOTHING, NOTHING);
	}

	@DisplayName("일치하는 숫자가 하나도 없으면 3낫씽")
	@ParameterizedTest
	@CsvSource(value = {"2,4,3", "2,9,7", "3,4,8"}, delimiter = ',')
	void nothing(int first, int second, int third) {
		final Balls question = Balls.of(first, second, third);
		final Balls answer = Balls.of(1, 5, 6);

		List<BallStatus> status = question.match(answer);

		assertThat(status.size()).isEqualTo(3);
		assertThat(status).containsExactlyInAnyOrder(NOTHING, NOTHING, NOTHING);
	}

	@DisplayName("같은 수가 다른자리에 3개 있으면 3볼")
	@ParameterizedTest
	@CsvSource(value = {"1,2,3", "3,1,2"}, delimiter = ',')
	void three_ball(int first, int second, int third) {
		final Balls question = Balls.of(first, second, third);
		final Balls answer = Balls.of(2, 3, 1);

		List<BallStatus> status = question.match(answer);

		assertThat(status.size()).isEqualTo(3);
		assertThat(status).containsExactly(BALL, BALL, BALL);
	}

	@DisplayName("같은 수가 같은 자리에 1개 있고 다른 자리에 1개 있고 일치하지 않는 것이 1개 있으면 1스트라이크 1볼 1낫씽")
	@Test
	void one_strike_one_ball_one_nothing() {
		final Balls question = Balls.of(1, 3, 5);
		final Balls answer = Balls.of(1, 2, 3);

		List<BallStatus> status = question.match(answer);

		assertThat(status.size()).isEqualTo(3);
		assertThat(status).containsExactly(STRIKE, BALL, NOTHING);
	}
}