package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
	@Test
	@DisplayName("사용자가 입력한 문자열을 토대로 Player 인스턴스가 생성되는지")
	void create() {
		// given
		String intString = "123";

		// when
		Player player = Player.create(intString);

		// then
		assertThat(player)
			.isNotNull()
			.isEqualTo(new Player(new Numbers(Arrays.asList(1, 2, 3))));
	}

	@Test
	@DisplayName("특정 Number가 존재하는지")
	void isContainsNumber() {
		// given
		Player player = new Player(new Numbers(Arrays.asList(1, 2, 3)));

		// when
		boolean existsNumber = player.isContainsNumber(new Number(1));
		boolean notExistsNumber = player.isContainsNumber(new Number(4));

		// then
		assertAll(
			() -> assertThat(existsNumber).isTrue(),
			() -> assertThat(notExistsNumber).isFalse()
		);
	}

	@Test
	@DisplayName("플레이어의 특정 Number 자릿수를 반환한다.")
	void getNumberDigit() {
		// given
		Player player = new Player(new Numbers(Arrays.asList(3, 1, 2)));

		// when
		int digit = player.getNumberDigit(new Number(4));
		int digitOfFirst = player.getNumberDigit(new Number(3));
		int digitOfSecond = player.getNumberDigit(new Number(1));
		int digitOfThird = player.getNumberDigit(new Number(2));

		// then
		assertAll(
			() -> assertThat(digit).isZero(),
			() -> assertThat(digitOfFirst).isEqualTo(1),
			() -> assertThat(digitOfSecond).isEqualTo(2),
			() -> assertThat(digitOfThird).isEqualTo(3)
		);
	}
}