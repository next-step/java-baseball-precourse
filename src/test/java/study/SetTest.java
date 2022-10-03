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
    @DisplayName("Set에 대해 중복 값을 삽입한 경우 크기 확인")
    void size() {
        // given
        int validSize = 3;
        int invalidSize = 4;

        // when
        int actualSize = numbers.size();

        // then
        assertThat(actualSize).isEqualTo(validSize);
        assertThat(actualSize).isNotEqualTo(invalidSize);
    }

    @ParameterizedTest(name = "Set에 대해 삽입한 값이 존재하는지 확인")
    @ValueSource(ints = {1, 2, 3})
    void contains(int number) {
        // then
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest(name = "Set에 대해 입력 값에 따라 결과 값이 다른 경우 테스트")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains(int number, boolean expected) {
        // then
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
