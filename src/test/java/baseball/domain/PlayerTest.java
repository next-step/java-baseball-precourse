package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;

class PlayerTest {
    @Test
    void Player_생성_테스트() {
        assertThatCode(() -> new Player("132")).doesNotThrowAnyException();
    }

    @Test
    void Player_는_3개의_공을_가지고_있다() {
        Balls hasBalls = new Player("179").getHasBalls();
        assertThat(hasBalls.getBall(0)).isEqualTo(new Ball(1));
        assertThat(hasBalls.getBall(1)).isEqualTo(new Ball(7));
        assertThat(hasBalls.getBall(2)).isEqualTo(new Ball(9));
    }
}
