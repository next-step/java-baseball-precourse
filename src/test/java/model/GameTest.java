package model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameTest {
	private Game game;

	@BeforeEach
	void setUp() {
		game = new Game();
	}

	@ParameterizedTest
	@CsvSource({"456,0,0", "416,0,1", "216,0,2", "312,0,3", "156,1,0", "136,1,1", "132,1,2", "126,2,0", "123,3,0"})
	@DisplayName("카운트를 정확하게 업데이트한다.")
	void updateCountTest(String input, int expectedStrike, int expectedBall) {
		game.answer.setNumberList("123");
		game.updateCount(input);
		assertThat(game.status.getStrikeCount()).isEqualTo(expectedStrike);
		assertThat(game.status.getBallCount()).isEqualTo(expectedBall);
	}

	@Test
	@DisplayName("3스트라이크일 경우 종료 플래그가 활성화 된다.")
	void isFinishTest() {
		game.answer.setNumberList("123");
		String input = "123";
		game.updateCount(input);
		assertThat(game.status.isFinish()).isTrue();
	}

	@Test
	@DisplayName("서로 다른 3개의 수를 생성한다.")
	void randomNumberTest() {
		game.answer.setRandomNumberList();
		int[] numberList = game.answer.getNumberList();
		int[] count = new int[4];
		Arrays.fill(count, 0);

		for (int number : numberList) {
			count[number]++;
		}
		assertThat(numberList[0]).isEqualTo(0);
		assertThat(count[0]).isEqualTo(7);
		assertThat(count[1]).isEqualTo(1);
		assertThat(count[2]).isEqualTo(1);
		assertThat(count[3]).isEqualTo(1);
	}
}