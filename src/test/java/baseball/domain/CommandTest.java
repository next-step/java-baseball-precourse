package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CommandTest {
    @Test
    void shouldBeREPLAY() {
        Command actual = Command.of(1);
        assertThat(actual).isEqualTo(Command.REPLAY);
    }

    @Test
    void shouldBeQUIT() {
        Command actual = Command.of(2);
        assertThat(actual).isEqualTo(Command.QUIT);
    }


    @Test
    void shouldThrowException() {
        assertThatThrownBy(() -> Command.of(3)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void replayIsTrueQuitIsFalse() {
        assertThat(Command.of(1).isReplay()).isTrue();
        assertThat(Command.of(2).isReplay()).isFalse();
    }
}
