package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
}
