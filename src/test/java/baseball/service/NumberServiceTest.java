package baseball.service;

import static org.assertj.core.api.Assertions.*;

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
}