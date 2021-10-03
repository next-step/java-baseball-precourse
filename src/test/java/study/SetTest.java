package study;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

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

	@DisplayName("Set의 크기 확인")
	@Test
	void size() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@DisplayName("contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지 확인")
	@Test
	void contains() {
		assertThat(numbers.contains(1)).isTrue();
		assertThat(numbers.contains(2)).isTrue();
		assertThat(numbers.contains(3)).isTrue();
	}

	@DisplayName("ParameterizedTest를 활용해 contains 메소드의 중복 코드 제거")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void contains_valueSource(int value) {
		assertThat(numbers.contains(value)).isTrue();
	}

	@DisplayName("1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void contains_CsvSource(int value, boolean flag) {
		assertThat(numbers.contains(value)).isEqualTo(flag);
	}
}