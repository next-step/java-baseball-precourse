package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
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
	@DisplayName("Set의 size() 를 활용하여 크기를 확인")
	void sizeTest() {
		int setSize = numbers.size();
		assertThat(setSize).isEqualTo(3);
		assertThat(setSize).isNotEqualTo(4);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("Set의 contains() 를 활용하여 1, 2, 3의 값이 존재하는 확인")
	void valueSourceTest(int input) {
		assertThat(numbers.contains(input)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"true:false", "4:false", "5:false", "1:true"}, delimiter = ':')
	@DisplayName("Set의 contains() 를 활용하여 true, 4, 5의 값이 존재하는 확인")
	void cvsSourceTest(@ConvertWith(IntConverter.class) int input, String expected) {
		if ("true".equals(expected)) {
			assertThat(numbers.contains(input)).isTrue();
		}

		if ("false".equals(expected)) {
			assertThat(numbers.contains(input)).isFalse();
		}
	}

}
