package baseball.domain;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


public class BallNumberVerificationTest {


    @Test
    @DisplayName("1 ~ 9까지 숫자인지 테스트")
    void isBetween1AndTest() {
        assertThat(Ball.isBetween1And(4)).isTrue();
        assertThat(Ball.isBetween1And(0)).isFalse();
    }


    @Test
    @DisplayName("지정한 3자리 숫자가 서로 다른 숫자인지 테스트")
    void composeOfDifferentNumbersTest() {
        assertThat(Balls.composeOfDifferentNumbers()).isTrue();
    }
}
