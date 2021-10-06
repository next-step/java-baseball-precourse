package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CountTest {

    @DisplayName("게임 추측 결과를 저장하는 Count 객체를 생성할 수 있다.")
    @Test
    void create() {
        assertDoesNotThrow(
            () -> new Count(0, 0)
        );
    }

    @DisplayName("올바르지 않은 스트라이크, 볼 갯수로 Count 객체를 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 4})
    void createInvalid(final int value) {
        assertThatThrownBy(
            () -> new Count(value, value)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("동등성을 비교할 수 있다.")
    @Test
    void equals() {
        final Count a = new Count(1, 2);
        final Count b = new Count(1, 2);

        assertThat(a).isEqualTo(b);
    }
}
