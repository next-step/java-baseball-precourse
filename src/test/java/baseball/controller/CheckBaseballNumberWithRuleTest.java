package baseball.controller;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.model.OpponentBaseballNumber;
import baseball.model.PlayerBaseballNumber;
import baseball.controller.CheckBaseballNumberWithRule;

public class CheckBaseballNumberWithRuleTest {

	@DisplayName("게임 룰 적용 테스트 - 스트라이크")
	@Test
	void runGameTestWithStrike() {
		OpponentBaseballNumber opponentBaseballNumber = new OpponentBaseballNumber(Arrays.asList(1,2,3));
		PlayerBaseballNumber playerBaseballNumber = PlayerBaseballNumber.createPlayerBaseballNumber("123");

		CheckBaseballNumberWithRule.checkBaseballNumber(opponentBaseballNumber, playerBaseballNumber);

		assertThat(playerBaseballNumber).extracting("strikeCount").isEqualTo(3);
	}

	@DisplayName("게임 룰 적용 테스트 - 1볼")
	@Test
	void runGameTestWithBall() {
		OpponentBaseballNumber opponentBaseballNumber = new OpponentBaseballNumber(Arrays.asList(4,1,5));
		PlayerBaseballNumber playerBaseballNumber = PlayerBaseballNumber.createPlayerBaseballNumber("123");

		CheckBaseballNumberWithRule.checkBaseballNumber(opponentBaseballNumber, playerBaseballNumber);

		assertThat(playerBaseballNumber).extracting("ballCount").isEqualTo(1);
	}

	@DisplayName("게임 룰 적용 테스트 - 낫싱")
	@Test
	void runGameTestWithNothing() {
		OpponentBaseballNumber opponentBaseballNumber = new OpponentBaseballNumber(Arrays.asList(1,2,3));
		PlayerBaseballNumber playerBaseballNumber = PlayerBaseballNumber.createPlayerBaseballNumber("456");

		CheckBaseballNumberWithRule.checkBaseballNumber(opponentBaseballNumber, playerBaseballNumber);

		assertThat(playerBaseballNumber).extracting("ballCount").isEqualTo(0);
		assertThat(playerBaseballNumber).extracting("strikeCount").isEqualTo(0);
	}
}
