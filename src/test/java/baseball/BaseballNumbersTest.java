package baseball;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballNumbersTest {
	@DisplayName("숫자가 같은 경우를 카운팅 한다.")
	@Test
	void count_same_number(){
		BaseballNumbers player = new BaseballNumbers(Arrays.asList(1,2,3));
		BaseballNumbers computer = new BaseballNumbers(Arrays.asList(1,3,9));

		int countOfSameNumber = player.countSameNumber(computer);

		Assertions.assertThat(countOfSameNumber).isEqualTo(2);
	}
	@DisplayName("숫자와 자리가 같은 경우를 카운팅 한다.")
	@Test
	void count_same_number_and_location(){
		BaseballNumbers player = new BaseballNumbers(Arrays.asList(1,2,3));
		BaseballNumbers computer = new BaseballNumbers(Arrays.asList(1,3,9));

		int countOfStrike = player.countSameNumberAndLocation(computer);

		Assertions.assertThat(countOfStrike).isEqualTo(1);
	}
}