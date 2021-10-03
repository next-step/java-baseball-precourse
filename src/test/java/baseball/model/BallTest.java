package baseball.model;

import baseball.model.enums.BallStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("공의 위치와 숫자를 가진 Ball")
public class BallTest {

    @DisplayName("공의 숫자가 1 이상 9 이하가 아니라면 Exception")
    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void testValidate(int invalidNumber) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Ball(0, invalidNumber))
                .withMessageMatching("공의 숫자는 1 이상 9 이하여야 합니다.");
    }

    @DisplayName("STRIKE: 공의 위치와 숫자가 모두 같음")
    @Test
    void testStrike() {
        Ball ball = new Ball(0, 1);
        Ball other = new Ball(0, 1);

        BallStatus ballStatus = ball.compareTo(other);

        assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @DisplayName("BALL: 공의 위치가 다르지만 숫자가 같음")
    @Test
    void testBall() {
        Ball ball = new Ball(0, 1);
        Ball other = new Ball(1, 1);

        BallStatus ballStatus = ball.compareTo(other);

        assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @DisplayName("NONE: 공의 위치에 관계 없이 숫자가 다르면 무조건 NONE")
    @ParameterizedTest
    @CsvSource(value = {
            "0, 2", // 위치는 같고 숫자는 다름
            "1, 2"  // 위치와 숫자 모두 다름
    })
    void testNone(int position, int number) {
        Ball ball = new Ball(0, 1);
        Ball other = new Ball(position, number);

        BallStatus ballStatus = ball.compareTo(other);

        assertThat(ballStatus).isEqualTo(BallStatus.NONE);
    }
}
