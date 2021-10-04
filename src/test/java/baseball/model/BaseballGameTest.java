package baseball.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.utils.NumberGenerator;

@DisplayName("야구 게임 테스트")
class BaseballGameTest {

	@DisplayName("게임이 정상적으로 수행되는지 확인한다")
	@Test
	void hit() {
		BaseballGame game = new BaseballGame(new InputGenerator(1, 2, 3));

		assertThat(game.hit(Arrays.asList(1, 2, 3)).isFinished()).isTrue();
		assertThat(game.hit(Arrays.asList(4, 2, 3)).isFinished()).isFalse();
	}

	static class InputGenerator implements NumberGenerator {

		private final int first;
		private final int second;
		private final int third;

		public InputGenerator(int first, int second, int third) {
			this.first = first;
			this.second = second;
			this.third = third;
		}

		@Override
		public List<Integer> generate() {
			return Arrays.asList(first, second, third);
		}
	}
}