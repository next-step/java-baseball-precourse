package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {

    @Test
    @DisplayName("01_사용자 입력 값 유효성 확인")
    void user_ball_input() {
        assertSimpleTest(() -> assertThatThrownBy(() -> new User("023"))
                .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() -> assertThatThrownBy(() -> new User("103"))
                .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() -> assertThatThrownBy(() -> new User("a03"))
                .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() -> assertThatThrownBy(() -> new User("1233"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }


}