package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.dto.MatchResult;
import baseball.dto.Numbers;

public class GameLogicTest {
	GameLogic gameLogic = new GameLogicImpl();

	@Test
	@DisplayName("3자리 숫자 생성 테스트")
	void createNumberSizeTest() {
		final Numbers number = gameLogic.createRandomNumbers();

		assertThat(number.numbers.size()).isEqualTo(3);
	}

	@Test
	@DisplayName("3자리 숫자 생성 중복 테스트")
	void createNumberRandomTest() {
		final Numbers number = gameLogic.createRandomNumbers();

		assertThat(number.numbers.size()).isEqualTo(new HashSet<>(number.numbers).size());
	}

	@Test
	@DisplayName("숫자 매치 테스트")
	void matchTest() {
		final Numbers number1 = new Numbers(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
		final Numbers number2 = new Numbers(new ArrayList<Integer>(Arrays.asList(2, 9, 3)));

		MatchResult matchResult = gameLogic.matchNumbers(number1, number2);

		assertThat(matchResult.ball).isEqualTo(1);
		assertThat(matchResult.strike).isEqualTo(1);
	}

	@Test
	@DisplayName("입력 값 기반 객체 생성 테스트")
	void createNumbersFromUserInputTest() {
		final int testNum1 = 321;
		final int testNum2 = 495;

		Numbers number1 = gameLogic.createNumbersFromUserInput(testNum1);
		Numbers number2 = gameLogic.createNumbersFromUserInput(testNum2);

		assertThat(number1.numbers).isEqualTo(new ArrayList<Integer>(Arrays.asList(3, 2, 1)));
		assertThat(number2.numbers).isEqualTo(new ArrayList<Integer>(Arrays.asList(4, 9, 5)));
	}

}
