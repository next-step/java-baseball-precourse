package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;

class BallNumberTest {
    @Test
    void 공의_숫자_는_1_이상의_값이어야한다() {
        assertThatCode(() -> new BallNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공의 숫자는 1부터 9의 값이어야 합니다.");
    }

    @Test
    void 공의_숫자는_9_이하의_값이어야한다() {
        assertThatCode(() -> new BallNumber(10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공의 숫자는 1부터 9의 값이어야 합니다.");
    }

    @Test
    void 공의_숫자_생성_테스트() {
        assertThatCode(() -> new BallNumber(9)).doesNotThrowAnyException();
    }

    @Test
    void 서로_다른_객체라도_값이_같을경우_같은_객체로_취급한다() {
        assertThat(new BallNumber(9)).isEqualTo(new BallNumber(9));
    }

    @Test
    void 값이_다를경우_다른_객체로_취급한다() {
        assertThat(new BallNumber(9)).isNotEqualTo(new BallNumber(3));
    }
}
