package study;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetCollectionTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인")
	@Test
	void sizeTest() {
		assertThat(numbers.size())
			.isEqualTo(3);
	}

	@DisplayName("Set의 contains() 메소드를 활용해 1,2,3의 값이 존재하는지를 확인")
	@ValueSource(ints = {1, 2, 3})
	@ParameterizedTest
	void containsTest(int containsNumber) {
		assertThat(numbers.contains(containsNumber))
			.isTrue();
	}

	@DisplayName(" 1,2,3 값은 contains 메소드 실행결과 true, 4,5값을 넣으면 false가 반환되는지 확인")
	@ParameterizedTest
	@CsvSource(value = {
		"1:true",
		"2:true",
		"3:true",
		"4:false",
		"5:false"
	}, delimiter = ':')
	void containsTestWithExpected(int containsNumber, boolean expected) {
		assertThat(numbers.contains(containsNumber))
			.isEqualTo(expected);
	}
}
