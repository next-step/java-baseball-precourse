package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.generator.NumbersGenerator;

class ComputerTest {
	@Test
	@DisplayName("컴퓨터는 NumbersGenerator를 통해 주입받아 생성할 수 있다.")
	void create() {
		// given
		NumbersGenerator generator = () -> new Numbers(Arrays.asList(1, 2, 3));

		// when
		Computer actual = Computer.create(generator);

		// then
		assertThat(actual)
			.isNotNull();
	}

	@Test
	@DisplayName("플레이어의 숫자를 비교하여 힌트를 제공한다.")
	void getHintFromPlayerNumbers() {
		// given
		Player player = Player.create("123");
		Computer computer = Computer.create(() -> new Numbers(Arrays.asList(1, 2, 4)));

		// when
		Hint hint = computer.getHintFromPlayerNumbers(player);

		// then
		Hint expected = Hint.create();
		expected = expected.hit(StrikeZone.STRIKE);
		expected = expected.hit(StrikeZone.STRIKE);
		expected = expected.hit(StrikeZone.NOTHING);
		assertThat(hint)
			.isEqualTo(expected);
	}
}