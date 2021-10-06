package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CheckerTest {

	@Test
	void 체크시나리오_낫싱(){
		Checker checker = new Checker();
		Numbers answer = new Numbers("123");
		Numbers goal = new Numbers("456");

		checker.answerCheck(answer, goal);

		int ball = checker.getBall();
		int strike = checker.getStrike();
		assertThat(ball).isZero();
		assertThat(strike).isZero();
	}

	@Test
	void 체크시나리오_볼(){
		Checker checker = new Checker();
		Numbers answer = new Numbers("123");
		Numbers goal = new Numbers("451");

		checker.answerCheck(answer, goal);

		int strike = checker.getStrike();
		assertThat(strike).isZero();

		int ball = checker.getBall();
		assertThat(ball).isEqualTo(1);
	}

	@Test
	void 체크시나리오_스트라이크(){
		Checker checker = new Checker();
		Numbers answer = new Numbers("123");
		Numbers goal = new Numbers("145");

		checker.answerCheck(answer, goal);

		int strike = checker.getStrike();
		assertThat(strike).isEqualTo(1);

		int ball = checker.getBall();
		assertThat(ball).isZero();
	}

}