package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {
	@DisplayName("낫싱 테스트")
	@Test
	public void 낫싱() {
		Game game = new Game("123", "456");
		Score score = game.checkScore();
		assertThat(score.getResultMsg()).isEqualTo("낫싱\n");
	}

	@DisplayName("3스트라이크 테스트")
	@Test
	public void 스트라이크3() {
		Game game = new Game("123", "123");
		Score score = game.checkScore();
		assertThat(score.getResultMsg()).contains("3스트라이크");
	}

	@DisplayName("n볼, n스트라이크 테스트")
	@Test
	public void n볼m스트라이크() {
		Game game = new Game("123", "321");
		Score score = game.checkScore();
		assertThat(score.getResultMsg()).contains("2볼 1스트라이크");
	}
}