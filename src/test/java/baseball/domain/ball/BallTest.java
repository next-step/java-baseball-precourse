package baseball.domain.ball;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void 인스턴스가_생성된다(int number) {
        assertThatCode(() -> new Ball(number))
            .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void 범위를_벗어날_경우_예외가_발생한다(int number) {
        assertThatThrownBy(() -> new Ball(number))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("볼은 1 ~ 9 사이여야 합니다.");
    }
}