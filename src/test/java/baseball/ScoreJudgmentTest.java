package baseball;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreJudgmentTest {
	@DisplayName("1스트라이크 1볼을 판단 할 수 있다")
	@Test
	void given_numbers_then_judgement_1strike_1ball(){
		BaseballNumbers player = new BaseballNumbers(Arrays.asList(1,2,3));
		BaseballNumbers computer = new BaseballNumbers(Arrays.asList(1,3,9));

		ScoreJudgment scoreJudgment = new ScoreJudgment();
		String result = scoreJudgment.judgment(player, computer);

		Assertions.assertThat(result).isEqualTo("1스트라이크 1볼");
	}

	@DisplayName("3스트라이크를 판단 할 수 있다")
	@Test
	void given_numbers_then_judgement_3strike(){
		BaseballNumbers player = new BaseballNumbers(Arrays.asList(1,2,3));
		BaseballNumbers computer = new BaseballNumbers(Arrays.asList(1,2,3));

		ScoreJudgment scoreJudgment = new ScoreJudgment();
		String result = scoreJudgment.judgment(player, computer);

		Assertions.assertThat(result).isEqualTo("3스트라이크");
	}

	@DisplayName("낫싱을 판단 할 수 있다")
	@Test
	void given_numbers_then_judgement_nothing(){
		BaseballNumbers player = new BaseballNumbers(Arrays.asList(1,2,3));
		BaseballNumbers computer = new BaseballNumbers(Arrays.asList(8,7,9));

		ScoreJudgment scoreJudgment = new ScoreJudgment();
		String result = scoreJudgment.judgment(player, computer);

		Assertions.assertThat(result).isEqualTo("낫싱");
	}

	@DisplayName("3볼을 판단 할 수 있다")
	@Test
	void given_numbers_then_judgement_3ball(){
		BaseballNumbers player = new BaseballNumbers(Arrays.asList(1,2,3));
		BaseballNumbers computer = new BaseballNumbers(Arrays.asList(2,3,1));

		ScoreJudgment scoreJudgment = new ScoreJudgment();
		String result = scoreJudgment.judgment(player, computer);

		Assertions.assertThat(result).isEqualTo("3볼");
	}
}