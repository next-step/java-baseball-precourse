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
	void setUp(){
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("set의 크기를 확인 할 수 있다")
	@Test
	void given_set_then_check_set_size(){
		assertThat(numbers)
			.hasSize(3);
	}

	@ParameterizedTest(name = "set에 {0}이 존재하는지 확인 할 수 있다.")
	@DisplayName("set에 특정 값이 존재하는지 확인할 수 있다.")
	@ValueSource(ints = {1, 2, 3})
	void given_value_then_check_include(int value){
		assertThat(numbers.contains(value))
			.isTrue();
	}

	@ParameterizedTest(name = "{0}의 존재 여부 {1}")
	@DisplayName("set에 특정 값의 존재 여부를 확인할 수 있다.")
	@CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
	void given_value_then_check_include_or_not(int value, boolean includeOrNot){
		assertThat(numbers.contains(value))
			.isEqualTo(includeOrNot);
	}
}
