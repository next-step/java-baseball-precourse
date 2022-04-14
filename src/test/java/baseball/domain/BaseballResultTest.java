package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballResultTest {
    @Test
    @DisplayName("결과 1스트라이크")
    void oneStrike() {
        // given
        int strike = 1;
        int ball = 0;

        // when
        BaseballResult result = new BaseballResult(strike, ball);

        // then
        assertThat(result.getMessage()).isEqualTo("1스트라이크");
    }

    @Test
    @DisplayName("결과 1볼 1스트라이크")
    void oneBallOneStrike() {
        // given
        int strike = 1;
        int ball = 1;

        // when
        BaseballResult result = new BaseballResult(strike, ball);

        // then
        assertThat(result.getMessage()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    @DisplayName("결과 낫싱")
    void nothing() {
        // given
        int strike = 0;
        int ball = 0;

        // when
        BaseballResult result = new BaseballResult(strike, ball);

        // then
        assertThat(result.getMessage()).isEqualTo("낫싱");
    }
}
