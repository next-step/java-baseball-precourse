package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.exception.InvalidBallNumberException;
import baseball.util.BallNumberUtil;
import baseball.vo.BallNumberVo;
import baseball.vo.GameResultVo;

public class BaseBallGameTest {
	private BaseBallGame baseBallGame;

	@BeforeEach
	public void initBaseBallGame() throws InvalidBallNumberException {
		BallNumberVo ballNumber = BallNumberUtil.stringToBallNumber("123");
		this.baseBallGame = new BaseBallGame(ballNumber);
	}

	@DisplayName("submitBallNumber, getGameResult 테스트")
	@Test
	void checkBallNumberInvalidNumber() throws InvalidBallNumberException {
		BallNumberVo ballNumber = BallNumberUtil.stringToBallNumber("456");
		baseBallGame.submitBallNumber(ballNumber);
		GameResultVo gameResult = baseBallGame.getGameResult();

		assertThat(gameResult.getBall()).isEqualTo(0);
		assertThat(gameResult.getStrike()).isEqualTo(0);

		ballNumber = BallNumberUtil.stringToBallNumber("132");
		baseBallGame.submitBallNumber(ballNumber);
		gameResult = baseBallGame.getGameResult();

		assertThat(gameResult.getBall()).isEqualTo(2);
		assertThat(gameResult.getStrike()).isEqualTo(1);

		ballNumber = BallNumberUtil.stringToBallNumber("123");
		baseBallGame.submitBallNumber(ballNumber);
		gameResult = baseBallGame.getGameResult();

		assertThat(gameResult.getBall()).isEqualTo(0);
		assertThat(gameResult.getStrike()).isEqualTo(3);
	}
}
