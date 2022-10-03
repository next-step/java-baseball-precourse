package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
// Test Case

    @Test
    @DisplayName("Set size test")
    void size_returnSetSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3,})
    @DisplayName("Set parameterized test")
    void contains_returnTrueWhenPassExistValueInSet(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("Set csvsource test")
    @ParameterizedTest
    @CsvSource( value = {"1 : true", "2 : true", "3 : true", "4 : false", "5 : false"}, delimiter = ':')
    void contains_returnTrueWhenPassExistValueInSetAndReturnFalseNotExistValuePass(int input, boolean expected) {
        assertEquals(numbers.contains(input), expected);
    }
}
