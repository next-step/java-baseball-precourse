package model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("GameResult 단위 테스트")
public class GameResultTest {

	@Nested
	@DisplayName("GameResult 생성")
	class GameResultConstructor_UnitTest {
		@Test
		@DisplayName("게임 결과를 생성한다.")
		void createGameResult() {
			// given
			final List<Integer> input = List.of(1, 2, 3);
			final List<Integer> answer = List.of(2, 1, 3);

			// when
			final GameResult gameResult = new GameResult(input, answer);

			// then
			assertThat(gameResult.getNumOfStrike()).isEqualTo(1);
			assertThat(gameResult.getNumOfBall()).isEqualTo(2);
		}
	}

	@Nested
	@DisplayName("isGameEnd: 게임 종료 여부를 반환한다.")
	class isGameEnd {
		@Test
		@DisplayName("게임 종료 상태를 만족하지 않으면 거짓을 반환한다.")
		void returnFalse() {
			// given
			final List<Integer> input = List.of(4, 5, 6);
			final List<Integer> answer = List.of(1, 2, 3);

			// when
			final GameResult gameResult = new GameResult(input, answer);

			// then
			assertThat(gameResult.getNumOfStrike()).isEqualTo(0);
			assertThat(gameResult.getNumOfBall()).isEqualTo(0);
			assertThat(gameResult.isGameEnd()).isFalse();
		}

		@Test
		@DisplayName("게임 종료 상태를 만족하면 참을 반환한다.")
		void returnTrue() {
			// given
			final List<Integer> input = List.of(1, 2, 3);
			final List<Integer> answer = List.of(1, 2, 3);

			// when
			final GameResult gameResult = new GameResult(input, answer);

			// then
			assertThat(gameResult.getNumOfStrike()).isEqualTo(3);
			assertThat(gameResult.isGameEnd()).isTrue();
		}
	}
}
