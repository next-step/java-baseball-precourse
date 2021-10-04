package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	void judgement_1strike_1ball(){
		List<Integer> playerNumbers = new ArrayList<>(Arrays.asList(1,2,3));
		List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(1,3,9));

		Game game = new Game();
		String result = game.judgment(playerNumbers, computerNumbers);

		Assertions.assertThat(result).isEqualTo("1스트라이크 1볼");
	}

	@Test
	void judgement_3strike(){
		List<Integer> playerNumbers = new ArrayList<>(Arrays.asList(1,2,3));
		List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(1,2,3));

		Game game = new Game();
		String result = game.judgment(playerNumbers, computerNumbers);

		Assertions.assertThat(result).isEqualTo("3스트라이크");
	}

	@Test
	void judgement_nothing(){
		List<Integer> playerNumbers = new ArrayList<>(Arrays.asList(1,2,3));
		List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(7,8,9));

		Game game = new Game();
		String result = game.judgment(playerNumbers, computerNumbers);

		Assertions.assertThat(result).isEqualTo("낫싱");
	}

	@Test
	void judgement_3ball(){
		List<Integer> playerNumbers = new ArrayList<>(Arrays.asList(1,2,3));
		List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(3,1,2));

		Game game = new Game();
		String result = game.judgment(playerNumbers, computerNumbers);

		Assertions.assertThat(result).isEqualTo("3볼");
	}

}