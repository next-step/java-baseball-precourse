package baseball.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.model.GameResult;

class PlayerTest {

	@DisplayName("컴퓨터와 플레이어 3개에 대해서 비교한 결과에 대한 테스트")
	@ParameterizedTest(name = "{displayName} / 컴퓨터: 123 vs 플레이어: {0}{1}{2} / 결과: strike={3}, ball={4}")
	@CsvSource(value = {"1:2:3:3:0", "2:1:3:1:2", "4:5:6:0:0"}, delimiter = ':')
	void play(int first, int second, int third, int strike, int ball) {
		// given
		final Player player = new Player("123");

		// when
		final GameResult gameResult = player.play(
			new Computer(Arrays.asList(
				first,
				second,
				third)));

		// then
		assertEquals(new GameResult(strike, ball), gameResult);
	}
}