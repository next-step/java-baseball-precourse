package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtBatResultTest {
    @Test
    @DisplayName("올바른 타석 결과를 생성한다.")
    void create_success_if_correct_at_bat_result() {
        int strike = 1;
        int ball = 1;

        assertDoesNotThrow(() -> AtBatResult.of(strike, ball));
    }

    @Test
    @DisplayName("올바르지 않은 스트라이크 수라면, 예외를 던진다.")
    void create_fail_if_wrong_strike_range() {
        int strike = 4;
        int ball = 0;

        assertThrows(Exception.class, () -> AtBatResult.of(strike, ball));
    }

    @Test
    @DisplayName("올바르지 않은 볼 수라면, 예외를 던진다.")
    void create_fail_if_wrong_ball_range() {
        int strike = 0;
        int ball = -1;

        assertThrows(Exception.class, () -> AtBatResult.of(strike, ball));
    }

    @Test
    @DisplayName("3스트라이크 라면, true를 반환한다.")
    void return_true_if_3_strike() {
        int strike = 3;
        int ball = 0;

        assertTrue(() -> AtBatResult.of(strike, ball).isSuccess());
    }

    @Test
    @DisplayName("3스트라이크가 아니라면, false를 반환한다.")
    void return_false_if_not_3_strike() {
        int strike = 1;
        int ball = 0;

        assertFalse(() -> AtBatResult.of(strike, ball).isSuccess());
    }

    @Test
    @DisplayName("0스트라이크, 0볼이라면 toString() 메서드에서 낫싱을 반환한다.")
    void return_nothing_if_call_toString_when_0strike_0ball() {
        int strike = 0;
        int ball = 0;

        assertEquals("낫싱", AtBatResult.of(strike, ball).toString());
    }
}
