package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Score;

class ScoreCalculatorTest {
	private ScoreCalculator scoreCalculator;

	@BeforeEach
	void setUp() {
		scoreCalculator = new ScoreCalculator();
	}

	@Test
	@DisplayName("정답을 맞추면 종료 flag가 활성화된다.")
	void finishScoreTest() {
		// given : 일치하는 숫자 문자열들이 존재한다
		String answer = "123";
		String input = "123";

		// when : 점수를 계산한다
		Score score = scoreCalculator.calculate(answer, input);

		// then : 정답을 맞췄다
		assertTrue(score.isFinished());
	}

	@Test
	@DisplayName("전부 틀리면 낫싱 메세지가 출력된다.")
	void nothingMessageTest() {
		// given : 전혀 다른 answer, input
		String answer = "123";
		String input = "456";

		// when : 점수 계산
		Score score = scoreCalculator.calculate(answer, input);

		// then : 메세지는 nothing
		assertEquals("낫싱", score.generateScoreMessage());
	}

	@Test
	@DisplayName("위치와 값이 일치하면 스트라이크, 값만 일치하면 볼 점수가 올라간다.")
	void calculateScoreTest() {
		// given : (위치와 값 일치)-(값만 일치)-(일치하지 않음) 조건의 input 문자열
		String answer = "123";
		String input = "135";

		// when : 점수 계산
		Score score = scoreCalculator.calculate(answer, input);

		// then : 1스트라이크, 1볼 메세지
		assertEquals("1스트라이크 1볼", score.generateScoreMessage());
	}
}