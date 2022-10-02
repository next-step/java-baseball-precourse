package baseball.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void 사용자가_잘못된_값을_입력하는_경우_에러_발생() {
        assertThatThrownBy(() -> new Player(Arrays.asList(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}