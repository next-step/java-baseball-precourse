package baseball.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ScoreCalculatorTest {

	BallNumbers computerBallNumbers;
	List<Integer> defaultNumbers = Arrays.asList(1, 2, 3);

	@BeforeEach
	void init() {
		computerBallNumbers = BallNumbers.of(defaultNumbers);
	}

	@Test
	@DisplayName("세 자리 수가 모두 일치하면 3스트라이크 0볼")
	void strikeTest() {
		// given
		BallNumbers userBallNumbers = BallNumbers.of(defaultNumbers);

		// when
		ScoreCalculator calculator = new ScoreCalculator(computerBallNumbers);
		Score score = calculator.calculateScore(userBallNumbers);

		// then
		assertThat(score.getStrike()).isEqualTo(3);
		assertThat(score.getBall()).isZero();
	}

	@Test
	@DisplayName("하나의 숫자도 일치하지 않으면 Result.NOTHING 리턴")
	void nothingTest() {
		// given
		List<Integer> numbers = Arrays.asList(4, 5, 6);
		BallNumbers userBallNumbers = BallNumbers.of(numbers);

		// when
		ScoreCalculator calculator = new ScoreCalculator(computerBallNumbers);
		Score score = calculator.calculateScore(userBallNumbers);

		// then
		assertThat(score.getStrike()).isZero();
		assertThat(score.getBall()).isZero();
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2,4,2,0", "1,4,2,1,1", "4,3,1,0,2", "3,1,2,0,3"})
	@DisplayName("세 자리 숫자가 모두 일치하지 않지만, 낫싱이 아니라면 Result.NOTHING 리턴")
	void continueTest(int first, int second, int third, int strike, int ball) {
		// given
		List<Integer> numbers = Arrays.asList(first, second, third);
		BallNumbers userBallNumbers = BallNumbers.of(numbers);

		// when
		ScoreCalculator calculator = new ScoreCalculator(computerBallNumbers);
		Score score = calculator.calculateScore(userBallNumbers);

		// then
		assertThat(score.getStrike()).isEqualTo(strike);
		assertThat(score.getBall()).isEqualTo(ball);
	}
}