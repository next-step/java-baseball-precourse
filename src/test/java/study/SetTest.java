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

    @DisplayName("Set의 size 메서드를 사용하면 Set의 크기를 반환한다")
    @Test
    void whenUsingSizeMethodOfSetDataStructure_thenGetSize() {
        // given
        // when
        // then
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set의 contains 메서드 사용 시 존재하는 값이 있다면 true 를 반환한다")
    void whenUsingContainsMethodOfSetDataStructureIfExistValue_thenReturnTrue(int containNo) {
        // given
        // when
        // then
        assertThat(numbers.contains(containNo)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 4, 5})
    @DisplayName("Set의 contains 메서드 사용 시 존재하지 않는 값이 있다면 false 를 반환한다")
    void whenUsingContainsMethodOfSetDataStructureIfNotExistValue_thenReturnFalse(int notContainNo) {
        // given
        // when
        // then
        assertThat(numbers.contains(notContainNo)).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("Set의 contains 메서드를 사용하면 특정 값이 존재하는지 확인할 수 있다")
    void whenUsingContainsMethodOfSetDataStructure_thenCanCheckSpecificValueExist(int searchNo, boolean expected) {
        // given
        // when
        // then
        assertThat(numbers.contains(searchNo)).isEqualTo(expected);
    }
}
