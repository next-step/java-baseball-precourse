package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.enums.ResultStatus;

class ResultTest {

	@Test
	@DisplayName("3스트라이크 이면 ResultStatus.WIN 반환")
	void strikeTest() {
		// given
		// when
		Result result = Result.of(new Score(3, 0));

		// then
		assertThat(result.getStatus()).isEqualTo(ResultStatus.WIN);
	}

	@Test
	@DisplayName("스트라이크와 볼이 모두 0 이면 ResultStatus.NOTHING 반환")
	void nothingTest() {
		// given
		// when
		Result result = Result.of(new Score(0, 0));

		// then
		assertThat(result.getStatus()).isEqualTo(ResultStatus.NOTHING);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,0", "0,1", "2,0", "0,2", "1,1"})
	@DisplayName("스트라이크와 볼이 모두 0 이 아니고 스트라이크가 3보다 작으면 ResultStatus.CONTINUE 반환")
	void continueTest(int strike, int ball) {
		// given
		// when
		Result result = Result.of(new Score(strike, ball));

		// then
		assertThat(result.getStatus()).isEqualTo(ResultStatus.CONTINUE);
	}

}