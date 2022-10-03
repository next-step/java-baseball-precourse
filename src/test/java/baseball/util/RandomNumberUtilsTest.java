package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberUtilsTest {

	@RepeatedTest(10)
	@DisplayName("지정한 범위의 중복되지 않은 숫자 리스트가 생성된다.")
	void generateNoneDuplicatedNumberList() {
		int minNo = 1;
		int maxNo = 9;
		int count = 3;

		List<Integer> numbers = RandomNumberUtils.generateNoneDuplicatedNumberList(minNo, maxNo, 3);
		assertThat(numbers).hasSize(count);

		// 중복 값 유무 테스트
		Set<Integer> nonDuplicatedNumbers = new HashSet<>(numbers);
		assertThat(numbers).hasSameSizeAs(nonDuplicatedNumbers);

		// 범위 지정 여부 테스트
		numbers.sort(Comparator.naturalOrder());
		assertThat(numbers.get(0)).isGreaterThanOrEqualTo(minNo);
		assertThat(numbers.get(numbers.size() - 1)).isLessThanOrEqualTo(maxNo);
	}
}