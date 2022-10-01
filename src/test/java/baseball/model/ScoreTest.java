package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreTest {

	@Test
	@DisplayName("strike 와 ball 개수가 모두 0 이면 isNothing() 메서드가 true 를 리턴한다.")
	void isNothingTest() {
		// given
		Score score = new Score(0, 0);
		// when
		// then
		assertThat(score.isNothing()).isTrue();
	}

	@Test
	@DisplayName("strike 개수가 3 이면 isWin() 메서드가 true 를 리턴한다.")
	void isWinTest() {
		// given
		Score score = new Score(3, 0);
		// when
		// then
		assertThat(score.isWin()).isTrue();
	}

}