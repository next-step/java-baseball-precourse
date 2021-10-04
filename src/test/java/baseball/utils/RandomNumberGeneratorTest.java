package baseball.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("랜덤 번호 생성기 테스트")
class RandomNumberGeneratorTest {

	@DisplayName("중복되지 않은 숫자를 주어진 수만큼 생성한다")
	@ParameterizedTest
	@ValueSource(ints = {3, 4, 5, 2})
	void generate(int size) {
		final NumberGenerator generator = new RandomNumberGenerator(size);
		final List<Integer> generateNumbers = generator.generate();

		final int generateSize = generateNumbers.size();
		final int convertSetSize = new HashSet<>(generateNumbers).size();

		assertThat(generateSize).isEqualTo(size);
		assertThat(convertSetSize).isEqualTo(generateSize);
	}
}