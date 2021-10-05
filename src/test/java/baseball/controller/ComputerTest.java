package baseball.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.model.Balls;
import baseball.model.GameResult;

class ComputerTest {

	@DisplayName("컴퓨터와 공 3개에 대해서 비교한 결과에 대한 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1:2:3:3:0", "2:1:3:1:2", "4:5:6:0:0"}, delimiter = ':')
	void play(int first, int second, int third, int strike, int ball) {
		// given
		final Computer computer = new Computer(Arrays.asList(1, 2, 3));

		// when
		final GameResult play = computer.play(
			new Balls(Arrays.asList(
				first,
				second,
				third)));

		// then
		assertEquals(play, new GameResult(strike, ball));
	}
}