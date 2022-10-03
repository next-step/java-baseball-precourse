package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HintTest {

    @Test
    @DisplayName("힌트 출력 테스트 - 볼")
    void hint_printBall() {
        Hint hint = new Hint(1, 0);
        assertThat(hint.toString()).contains("1볼");
    }

    @Test
    @DisplayName("힌트 출력 테스트 - 스트라이크")
    void hint_printStrike() {
        Hint hint = new Hint(0, 2);
        assertThat(hint.toString()).contains("2스트라이크");
    }

    @Test
    @DisplayName("힌트 출력 테스트 - 볼 && 스트라이크")
    void hint_printBallAndStrike() {
        Hint hint = new Hint(1, 2);
        assertThat(hint.toString()).contains("1볼 2스트라이크");
    }

    @Test
    @DisplayName("볼의 존재 유무를 확인")
    void hint_isExistBall() {
        Hint hint = new Hint(1, 0);
        assertTrue(hint.isExistBall());
    }

    @Test
    @DisplayName("스트라이크의 존재 유무를 확인")
    void hint_isExistStrike() {
        Hint hint = new Hint(0, 1);
        assertTrue(hint.isExistStrike());
    }

    @Test
    @DisplayName("3스트라이크 인지 확인")
    void hint_isThreeStrike() {
        Hint hint = new Hint(0, 3);
        assertTrue(hint.isThreeStrike());
    }
}