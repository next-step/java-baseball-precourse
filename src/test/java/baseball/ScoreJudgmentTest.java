package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ScoreJudgmentTest {
	@Test
	void compute_score(){
		List<Integer> playerNumbers = new ArrayList<>(Arrays.asList(1,2,3));
		List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(1,3,9));

		ScoreJudgment judgment = new ScoreJudgment();
		int countOfSameNumber = judgment.countSameNumber(playerNumbers, computerNumbers);
		int countOfStrike = judgment.countSameNumberAndLocation(playerNumbers, computerNumbers);

		Assertions.assertThat(countOfSameNumber).isEqualTo(2);
		Assertions.assertThat(countOfStrike).isEqualTo(1);
	}

}