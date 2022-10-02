package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;

class BallTest {
    @Test
    void 볼_생성_테스트() {
        assertThatCode(() -> new Ball(1)).doesNotThrowAnyException();
    }

    @Test
    void 서로_다른_객체라도_값이_같으면_같은_객체로_취급한다() {
        assertThat(new Ball(1)).isEqualTo(new Ball(1));
    }

    @Test
    void 값이_다를_경우_다른_객체로_취급한다() {
        assertThat(new Ball(1)).isNotEqualTo(new Ball(2));
    }
}
