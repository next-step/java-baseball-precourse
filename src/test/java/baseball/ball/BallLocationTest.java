package baseball.ball;

import baseball.ball.domain.BallLocation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("볼 위치")
class BallLocationTest {

    @DisplayName("볼 위치 생성")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void createBallLocation(BigDecimal location) {
        assertDoesNotThrow(() -> new BallLocation(location));
    }

    @DisplayName("볼 위치는 3보다 클 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"4", "5"})
    void maxBallLocation(BigDecimal location) {
        assertThatThrownBy(() -> new BallLocation(location))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3보다 클 수 없습니다.");
    }

    @DisplayName("볼 위치는 1보다 작을 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void minBallLocation(BigDecimal location) {
        assertThatThrownBy(() -> new BallLocation(location))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1보다 작을 수 없습니다.");
    }

}
