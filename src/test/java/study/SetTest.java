package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SetTest {

	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("BeforeEach 에서 데이터를 삽입한 뒤의 Set 내의 데이터의 갯수를 확인한다.")
	@Test
	void size() {
		// given: none

		// when then
		assertEquals(3, numbers.size());
	}

	@DisplayName("삽입한 데이터가 존재하는지 확인하는 테스트이다. / ValueSource 사용")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void contains_with_ValueSource(int input) {
		// given: none

		// when then
		assertTrue(numbers.contains(input));
	}

	@DisplayName("삽입한 데이터가 존재하는지 확인하는 테스트이다. / CsvSource 사용")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void contains_with_CsvSource(int input, boolean result) {
		// given: none

		// when then
		assertThat(numbers.contains(input)).isEqualTo(result);
	}

	@DisplayName("Set을 List로 재할당하는 경우, Sort 가 되는 현상을 확인하기 위한 테스트")
	@Test
	void set_to_list() {
		// given
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(7);
		set.add(4);

		// when
		List<Integer> list = new ArrayList<>(set);

		// then
		assertEquals(1, list.get(0));
		assertEquals(4, list.get(1));
		assertEquals(7, list.get(2));
	}

}
