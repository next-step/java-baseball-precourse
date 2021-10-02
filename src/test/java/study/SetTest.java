package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@Test
	@DisplayName("Set 사이즈 테스트")
	void setSizeTest() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@Test
	@DisplayName("Set Contains 테스트")
	void setContainsTest() {
		assertThat(numbers.contains(1)).isTrue();
		assertThat(numbers.contains(2)).isTrue();
		assertThat(numbers.contains(3)).isTrue();
		assertThat(numbers.contains(4)).isFalse();
	}

	@DisplayName("ParameterizedTest를 통한 Set Contains 테스트")
	@ParameterizedTest
	@ValueSource(ints = {1,2,3})
	void setContainsParameterizedTest(int i) {
		assertThat(numbers.contains(i)).isTrue();
	}

	@DisplayName("여러값을 인자로 받는 반복테스트")
	@ParameterizedTest(name ="{displayName} {0} -> {1} ")
	@CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
	void setContainsCsvSourceTest(int i, boolean expected) {
		assertThat(numbers.contains(i)).isEqualTo(expected);
	}
}
