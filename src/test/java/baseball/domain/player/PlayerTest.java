package baseball.domain.player;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void 정적_팩토리_테스트() {
        assertThatCode(() -> Player.from("123"))
            .doesNotThrowAnyException();
    }
}
