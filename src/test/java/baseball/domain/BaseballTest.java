package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class BaseballTest {

    @Test
    public void Baseball객체_확인() {
        Baseball baseball = new Baseball(1);
        assertThat(baseball).isInstanceOf(Baseball.class);
    }

    @Test
    public void Baseball숫자_예외_처리() {
        assertThatThrownBy(() -> {
            Baseball baseball = new Baseball(10);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}