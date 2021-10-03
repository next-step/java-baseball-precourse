package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("게임 결과 테스트")
class GameStatusTest {

	@Test
	@DisplayName("스트라이크나 볼을 하나도 못맞췄을 때")
	void isNothing() {
		Game game = new Game();
		assertThat(game.getGameStatus()).isEqualTo(GameStatus.NOTHING);
		assertThat(game.toString()).isEqualTo("낫싱");
	}

	@Test
	@DisplayName("스트라이크나 볼을 맞췄을 때")
	void isIncorrect() {
		Game game = new Game();
		game.addStrike();
		game.addStrike();
		game.addBall();
		assertThat(game.getGameStatus()).isEqualTo(GameStatus.INCORRECT);
		assertThat(game.toString()).isEqualTo("2스트라이크 1볼");
	}

	@Test
	@DisplayName("스트라이크를 모두 맞췄을 때")
	void isCorrect() {
		Game game = new Game();
		game.addStrike();
		game.addStrike();
		game.addStrike();
		assertThat(game.getGameStatus()).isEqualTo(GameStatus.CORRECT);
		assertThat(game.toString()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임끝");
	}

}
