package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}
