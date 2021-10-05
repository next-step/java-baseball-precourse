package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameResultTest {

	@DisplayName("toString 테스트")
	@ParameterizedTest(name = "{displayName} / strike = {0}, ball = {1} / 예상 = {2}")
	@CsvSource(delimiter = ':', value = {"0:0:낫싱",
		"0:1:1볼", "0:2:2볼",
		"1:0:1스트라이크", "1:1:1스트라이크 1볼", "1:2:1스트라이크 2볼",
		"2:0:2스트라이크", "2:1:2스트라이크 1볼",
		"3:0:3스트라이크"})
	void toString(int strike, int ball, String expected) {
		// given
		final GameResult gameResult = new GameResult(strike, ball);

		// when then
		assertEquals(expected, gameResult.toString());
	}

	@DisplayName("toString 테스트")
	@ParameterizedTest(name = "{displayName} / 게임결과에 따른 게임결과 변화 / 0strike 0ball -> {0} -> {1}strike {2}ball")
	@CsvSource(value = {"NOTHING:0:0", "BALL:0:1", "STRIKE:1:0"}, delimiter = ':')
	void applyGameResult(GameStatus gameStatus, int strike, int ball) {
		// given
		final GameResult before = new GameResult(0, 0);

		// when
		final GameResult after = before.applyGameStatus(gameStatus);

		// then
		assertEquals(new GameResult(strike, ball), after);
	}

}