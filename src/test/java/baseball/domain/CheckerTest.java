package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CheckerTest {

	@ParameterizedTest
	@CsvSource(value = {"123:456", "789:456"}, delimiter = ':')
	void 체크시나리오_낫싱(String answerValue, String goalValue){
		Checker checker = new Checker();
		Numbers answer = new Numbers(answerValue);
		Numbers goal = new Numbers(goalValue);

		checker.answerCheck(answer, goal);

		int ball = checker.getBall();
		int strike = checker.getStrike();
		assertThat(ball).isZero();
		assertThat(strike).isZero();
	}

	@ParameterizedTest
	@CsvSource(value = {"123:516:1", "456:548:2", "123:312:3"}, delimiter = ':')
	void 체크시나리오_볼(String answerValue, String goalValue, int ballCount){
		Checker checker = new Checker();
		Numbers answer = new Numbers(answerValue);
		Numbers goal = new Numbers(goalValue);

		checker.answerCheck(answer, goal);

		int strike = checker.getStrike();
		assertThat(strike).isZero();

		int ball = checker.getBall();
		assertThat(ball).isEqualTo(ballCount);
	}

	@ParameterizedTest
	@CsvSource(value = {"123:156:1", "456:458:2", "123:123:3"}, delimiter = ':')
	void 체크시나리오_스트라이크(String answerValue, String goalValue, int strikeCount){
		Checker checker = new Checker();
		Numbers answer = new Numbers(answerValue);
		Numbers goal = new Numbers(goalValue);

		checker.answerCheck(answer, goal);

		int ball = checker.getBall();
		assertThat(ball).isZero();

		int strike = checker.getStrike();
		assertThat(strike).isEqualTo(strikeCount);

	}

	@Test
	void 올스트라이크_확인(){
		Checker checker = new Checker();
		Numbers answer = new Numbers("123");
		Numbers goal = new Numbers("123");

		checker.answerCheck(answer, goal);

		assertThat(checker.isAllStrike()).isTrue();
	}

}