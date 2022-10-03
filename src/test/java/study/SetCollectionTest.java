package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetCollectionTest {

	@Test
	void 요구사항_1(){
		Set<String> set = new HashSet<>();
		set.add("test1");
		set.add("test2");
		set.add("test3");
		set.add("test4");

		assertThat(set.size()).isEqualTo(4);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void 요구사항_2(int num) {
		Set<Integer> numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);

		assertThat(numbers.contains(num)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void 요구사항_3(int num, boolean expected) {
		Set<Integer> numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);

		assertThat(numbers.contains(num)).isEqualTo(expected);
	}
}
