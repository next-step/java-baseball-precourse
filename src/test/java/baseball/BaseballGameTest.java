package baseball;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BaseballGameTest {

	@Test
	void judgement_1strike_1ball(){
		BaseballNumbers player = new BaseballNumbers(Arrays.asList(1,2,3));
		BaseballNumbers computer = new BaseballNumbers(Arrays.asList(1,3,9));

		BaseballGame baseballGame = new BaseballGame();
		String result = baseballGame.judgment(player, computer);

		Assertions.assertThat(result).isEqualTo("1스트라이크 1볼");
	}

	@Test
	void judgement_3strike(){
		BaseballNumbers player = new BaseballNumbers(Arrays.asList(1,2,3));
		BaseballNumbers computer = new BaseballNumbers(Arrays.asList(1,2,3));

		BaseballGame baseballGame = new BaseballGame();
		String result = baseballGame.judgment(player, computer);

		Assertions.assertThat(result).isEqualTo("3스트라이크");
	}

	@Test
	void judgement_nothing(){
		BaseballNumbers player = new BaseballNumbers(Arrays.asList(1,2,3));
		BaseballNumbers computer = new BaseballNumbers(Arrays.asList(8,7,9));

		BaseballGame baseballGame = new BaseballGame();
		String result = baseballGame.judgment(player, computer);

		Assertions.assertThat(result).isEqualTo("낫싱");
	}

	@Test
	void judgement_3ball(){
		BaseballNumbers player = new BaseballNumbers(Arrays.asList(1,2,3));
		BaseballNumbers computer = new BaseballNumbers(Arrays.asList(2,3,1));

		BaseballGame baseballGame = new BaseballGame();
		String result = baseballGame.judgment(player, computer);

		Assertions.assertThat(result).isEqualTo("3볼");
	}
}