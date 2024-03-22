package model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("GameResult 단위 테스트")
public class GameResultTest {

	@Test
	@DisplayName("게임 결과를 생성한다.")
	void test01() {
		// given
		final String input = "123";
		final List<Integer> answer = List.of(2, 1, 3);

		// when
		final GameResult gameResult = new GameResult(input, answer);

		// then
		assertThat(gameResult.getNumOfStrike()).isEqualTo(1);
		assertThat(gameResult.getNumOfBall()).isEqualTo(2);
	}
}
