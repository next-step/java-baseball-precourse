package study;

import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("size() 메소드를 활용해 Set의 크기를 확인한다.")
    void size_int() {
        // when
        int size = numbers.size();

        // then
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest(name = "element : {arguments}")
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("contains를 사용해 원소의 값이 존재하는지를 확인한다.")
    void contains_boolean(int element) {
        // when
        boolean contain = numbers.contains(element);

        // then
        assertThat(contain).isTrue();
    }

    @ParameterizedTest(name = "element : {0}, expected: {1}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("contains를 사용해 원소의 값이 존재하는지를 확인한다.")
    void contains_withNotExistElement_boolean(int element, boolean expected) {
        // when
        boolean contain = numbers.contains(element);

        // then
        assertThat(contain).isEqualTo(expected);
    }
}
