package baseball.generator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.Numbers;

class RandomNumbersGeneratorTest {
	@Test
	@DisplayName("에러 없이 세 자리 난수 생성이 되는지")
	void createNumbers() {
		// given
		NumbersGenerator generator = new RandomNumbersGenerator();

		// when
		Numbers randomNumbers = generator.createNumbers();

		// then
		assertThat(randomNumbers)
			.isNotNull()
			.satisfies(numbers -> assertThat(numbers.getValues())
				.hasSize(Numbers.SIZE));
	}
}