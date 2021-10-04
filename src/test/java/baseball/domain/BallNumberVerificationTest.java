package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class BallNumberVerificationTest {


    @Test
    @DisplayName("1 ~ 9까지 숫자인지 테스트")
    void isBetween1AndTest() {
        assertThat(Ball.isBetween1And(4)).isTrue();
        assertThat(Ball.isBetween1And(0)).isFalse();
    }
}
