package baseball.controller;

import baseball.common.NumberOption;
import baseball.domain.BaseballNumber;
import baseball.domain.GameResult;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("게임Rule Controller Test")
class GameRuleTest {

	@DisplayName("getResult test")
	@Test
	public void getResultTest() {
		BaseballNumber playerNumber = new BaseballNumber();
		BaseballNumber computerNumber = new BaseballNumber();
		GameRule gameRule = new GameRule(playerNumber, computerNumber);
		GameResult gameResult = gameRule.getResult();
		assertTrue(gameResult.getStrike() <= NumberOption.MAX_SIZE.getValue());
		assertTrue(gameResult.getStrike() >= NumberOption.ZERO.getValue());
		assertTrue(gameResult.getBall() <= NumberOption.MAX_SIZE.getValue());
		assertTrue(gameResult.getBall() >= NumberOption.ZERO.getValue());
	}

	@Test
	@DisplayName("3스트라이크 test")
	public void threeStrikeTest() {
		BaseballNumber playerNumber = new BaseballNumber(173);
		BaseballNumber computerNumber = new BaseballNumber(173);
		GameRule gameRule = new GameRule(playerNumber, computerNumber);
		GameResult gameResult = gameRule.getResult();
		assertEquals(NumberOption.MAX_SIZE.getValue(), gameResult.getStrike());
	}

	@Test
	@DisplayName("3볼 test")
	public void threeBallTest() {
		BaseballNumber playerNumber = new BaseballNumber(173);
		BaseballNumber computerNumber = new BaseballNumber(731);
		GameRule gameRule = new GameRule(playerNumber, computerNumber);
		GameResult gameResult = gameRule.getResult();
		assertEquals(NumberOption.MAX_SIZE.getValue(), gameResult.getBall());
	}

	@Test
	@DisplayName("1볼 1스트라이크 test")
	public void oneBallOneStrikeTest() {
		BaseballNumber playerNumber = new BaseballNumber(173);
		BaseballNumber computerNumber = new BaseballNumber(376);
		GameRule gameRule = new GameRule(playerNumber, computerNumber);
		GameResult gameResult = gameRule.getResult();
		assertEquals(1, gameResult.getBall());
		assertEquals(1, gameResult.getStrike());
	}
}