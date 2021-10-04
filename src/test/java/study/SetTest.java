package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Set 클래스에 대한 학습 테스트")
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
    @DisplayName("Set의 크기 확인")
    void checkSetSize() {
        // given // when
        Integer result = numbers.size();

        // then
        assertAll(
                () -> assertThat(numbers).isNotEmpty(),
                () -> assertThat(result).isEqualTo(3)
        );
    }

    @ParameterizedTest(name = "정의한 Set에 {0}이 존재하는지 확인")
    @ValueSource(ints = {1, 2, 3})
    void checkSetValuesContains(int number) {
        // then
        assertAll(
                () -> assertThat(numbers).isNotEmpty(),
                () -> assertThat(numbers.contains(number)).isTrue()
        );
    }

    @ParameterizedTest(name = "{0}의 존재여부에 따라 기대 값을 반환하는지 확인")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void checkSetValuesBoolean(int number, boolean result) {
        // then
        assertAll(
                () -> assertThat(numbers).isNotEmpty(),
                () -> assertThat(numbers.contains(number)).isEqualTo(result)
        );
    }
}
