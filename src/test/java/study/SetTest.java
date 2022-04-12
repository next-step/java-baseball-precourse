package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void beforeAll() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void Should_ReturnTheSize_When_CallSizeMethod() {
        // when
        final int result = numbers.size();
        // then
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void Should_ReturnTheSize_When_CallSizeMethod(int when) {
        // then
        assertThat(numbers).contains(when);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
    void Should_ReturnTheSize_When_CallSizeMethod(int when, boolean expect) {
        // then
        assertThat(numbers.contains(when)).isEqualTo(expect);
    }
}
