package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {


    @Test
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.")
    void getSize() {

        Set<String> set = new HashSet();

        assertThat(set.size()).isEqualTo(0);
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
//    @ValueSource( ints = {4, 5})
    @DisplayName("JUnit의 ParameterizedTest를 활용해 중복 코드를 제거")
    void testParameterized(int input) {

        Set<Number> numbers = new HashSet();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        assertTrue(numbers.contains(input));
    }

    @ParameterizedTest
//    @CsvSource( value = {"1", "2", "3"})
    @CsvSource(value = {"4", "5"})
    @DisplayName("JUnit의 ParameterizedTest를 활용해 중복 코드를 제거")
    void testParameterized2(int input) {

        Set<Number> numbers = new HashSet();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        assertTrue(numbers.contains(input));
    }


}
