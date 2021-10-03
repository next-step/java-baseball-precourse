package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class NumberGeneratorTest {

	@RepeatedTest(name = "{displayName} - ${currentRepetition} / ${totalRepetitions}", value = 10)
	@DisplayName("중복없는 랜덤 숫자 생성 테스트")
	void 랜덤_숫자_생성() {
		List<Integer> numbers = NumberGenerator.createNumber();
		assertTrue(isDuplicated(numbers));
	}

	private boolean isDuplicated(List<Integer> list) {
		Set<Integer> set = new HashSet<>();
		for (int i : list) {
			if (!set.add(i)) {
				return false;
			}
		}
		return true;
	}

}
