package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @DisplayName("집합의 크기를 구할 수 있다")
    @Test
    void 크기를_구할수있다() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("집합에 포함여부를 알 수 있다")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void 포함여부를_알수있다(String input, String expect) {
        Boolean result = Boolean.parseBoolean(expect);
        assertThat(numbers.contains(Integer.parseInt(input))).isEqualTo(result);
    }
}
