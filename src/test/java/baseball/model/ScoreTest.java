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

class ScoreTest {

	@DisplayName("플레이어의 숫자에 대한 힌트 출력시 올바른 힌트를 출력하는지 테스트")
	@ParameterizedTest
	@CsvSource(value = {"124,1스트라이크", "152,1스트라이크 1볼", "987,낫싱", "135,3스트라이크"})
	void getScoreMessage(final String num, final String message) {
		Score score = createScore(num);
		assertThat(score.getScoreMessage()).contains(message);
	}

	@DisplayName("스코어 생성시 스트라이크 카운트의 범위 테스트")
	@ParameterizedTest
	@CsvSource(value = {"124", "152", "987", "135"})
	void getStrikeCount(final String num) {
		Score score = createScore(num);
		assertThat(score.getStrikeCount())
			.isBetween(0, 3);
	}

	private Score createScore(final String num) {
		Computer computer;
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
				.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(1, 3, 5);
			computer = new Computer();
		}
		List<Integer> numbers = convertNumbers(num);
		int strikeCount = computer.getStrikeCount(numbers);
		return new Score(strikeCount, computer.getBallCount(numbers, strikeCount));
	}
}
