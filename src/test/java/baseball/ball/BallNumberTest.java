package baseball.ball;

import baseball.ball.domain.BallNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("볼 숫자")
class BallNumberTest {

    @DisplayName("볼 숫자 생성")
    @ParameterizedTest
    @ValueSource(strings = {"1", "9"})
    void createBallNumber(BigDecimal number) {
        assertDoesNotThrow(() -> new BallNumber(number));
    }

    @DisplayName("볼 숫자는 9보다 클 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"10", "11"})
    void maxBallNumber(BigDecimal number) {
        assertThatThrownBy(() -> new BallNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("9보다 클 수 없습니다.");
    }

    @DisplayName("볼 숫자는 1보다 작을 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void minBallNumber(BigDecimal number) {
        assertThatThrownBy(() -> new BallNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1보다 작을 수 없습니다.");
    }

}
