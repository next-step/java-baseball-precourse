package baseball.service;

import static org.assertj.core.api.Assertions.*;

import baseball.model.Game;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberServiceTest {

	@Test
	@DisplayName("야구게임 숫자 세팅하고 그값 받아와보기")
	public void test1() throws Exception {
		NumberService numberService = new NumberService();
		numberService.resetGame();

		String findGoal = numberService.getGameGoal();
		System.out.println(findGoal);

		for (int i = 0; i < 3; i++) {
			Integer num = Integer.valueOf(findGoal.substring(i, i + 1));
			System.out.println(num);
			assertThat(num)
					.isGreaterThanOrEqualTo(1)
					.isLessThanOrEqualTo(9);
		}
	}


	@Test
	@DisplayName("한자리 추측해보기")
	public void test2() throws Exception {
		NumberService numberService = new NumberService();
		numberService.resetGame();

		boolean result = false;
		for (int i = 1; i < 10; i++) {
			System.out.println(numberService.isStrike(0, i));
			result = numberService.isStrike(0, i) || result;
		}

		Assertions.assertThat(result).isTrue();
	}


	@Test
	@DisplayName("isStrike")
	public void test3() throws Exception {
		Game game = Game.getInstance();
		game.setGoal("123");

		NumberService numberService = new NumberService();

		Assertions.assertThat(numberService.isStrike(0, 1)).isTrue();
		Assertions.assertThat(numberService.isStrike(0, 2)).isFalse();
	}

	@Test
	@DisplayName("isBall")
	public void test4() throws Exception {
		Game game = Game.getInstance();
		game.setGoal("123");

		NumberService numberService = new NumberService();

		Assertions.assertThat(numberService.isBall(2)).isTrue();
		Assertions.assertThat(numberService.isBall(9)).isFalse();
	}


}