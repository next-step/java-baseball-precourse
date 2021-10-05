package baseball.model;

import static nextstep.test.TestUtils.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;

class ComputerTest {

	@DisplayName("컴퓨터의 3자리 숫자 중 같은 자리의 같은 숫자를 맞출 경우 Strike 갯수 테스트")
	@CsvSource(value = {"123,1", "235,2", "135,3"})
	@ParameterizedTest
	void getStrikeCount(final String num, final int strikeCount) {
		Computer computer;
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
				.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(1, 3, 5);
			computer = new Computer();
		}
		List<Integer> numbers = convertNumbers(num);
		assertThat(computer.getStrikeCount(numbers)).isEqualTo(strikeCount);
	}

	@DisplayName("컴퓨터의 3자리 숫자 중 다른 자리의 같은 숫자를 맞출 경우 Ball 갯수 테스트")
	@CsvSource(value = {"981,1", "913,2", "351,3"})
	@ParameterizedTest
	void getBallCount(final String num, final int ballCount) {
		Computer computer;
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
				.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(1, 3, 5);
			computer = new Computer();
		}
		List<Integer> numbers = convertNumbers(num);
		assertThat(computer.getBallCount(numbers, computer.getStrikeCount(numbers))).isEqualTo(ballCount);
	}
}