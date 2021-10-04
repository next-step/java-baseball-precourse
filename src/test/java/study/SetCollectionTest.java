package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetCollectionTest {

	private Set<Object> numbers;

	@BeforeEach
	void setUp(){
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@Test
	void size_테스트(){
		int size = numbers.size();

		assertThat(size).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void 특정값이_존재하는지_테스트(int value){
		assertThat(numbers.contains(value)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "3:true", "4:false", "100:false"}, delimiter = ':')
	void 특정값이_존재하거나_없는지_테스트(int value, boolean result){
		assertThat(numbers.contains(value)).isEqualTo(result);
	}
}
