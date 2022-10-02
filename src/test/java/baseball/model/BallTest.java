package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallTest {

    @Test
    @DisplayName("01_야구볼 생성 예외 확인")
    void ball_create_exception() {
        assertSimpleTest(() -> assertThatThrownBy(() -> new Ball(0))
                .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() -> assertThatThrownBy(() -> new Ball(10))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

}