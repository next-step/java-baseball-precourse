package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ComputerTest {
	@Test
	void create_three_random_number() {
		Computer computer = new Computer();
		BaseballNumbers baseballNumbers = computer.createBaseballNumbers();

		assertThat(baseballNumbers.getBaseballNumbers())
			.hasSize(3);
	}
}