package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberTest {

    @DisplayName("1부터 9까지 서로 다른 수로 이루어진 3자리 숫자를 생성할 수 있다.")
    @Test
    void create() {
        assertDoesNotThrow(
            () -> new Number("123")
        );
    }

    @DisplayName("1부터 9까지 서로 다른 수로 이루어진 3자리의 수 외 다른 숫자는 생성할 수 없다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"a", "1", "12", "1234", "012", "102", "120", "112", "122", "111"})
    void createInvalid(final String value) {
        assertThatThrownBy(
            () -> new Number(value)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("동등성을 비교할 수 있다.")
    @Test
    void equals() {
        final Number a = new Number("123");
        final Number b = new Number("123");

        assertThat(a).isEqualTo(b);
    }

    @DisplayName("해당 자리의 값을 비교할 수 있다.")
    @Test
    void equalsAt() {
        final Number a = new Number("123");
        final Number b = new Number("145");

        assertAll(
            () -> assertThat(a.equalsAt(b, 0)).isTrue(),
            () -> assertThat(a.equalsAt(b, 1)).isFalse(),
            () -> assertThat(a.equalsAt(b, 2)).isFalse()
        );
    }

    @DisplayName("해당 자리를 제외한 값을 비교할 수 있다.")
    @Test
    void containsExceptAt() {
        final Number a = new Number("123");
        final Number b = new Number("351");

        assertAll(
            () -> assertThat(a.containsExceptAt(b, 0)).isTrue(),
            () -> assertThat(a.containsExceptAt(b, 1)).isFalse(),
            () -> assertThat(a.containsExceptAt(b, 2)).isTrue()
        );
    }
}
