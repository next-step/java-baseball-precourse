package baseball.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;



public class BallNumberVerificationTest {

    Balls testBalls;

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


    @BeforeEach
    void settings() {
        Ball b1 = new Ball(1,3);
        Ball b2 = new Ball(2,4);
        Ball b3 = new Ball(3, 9);

        testBalls = new Balls(new ArrayList<>(Arrays.asList(b1,b2,b3)));
    }


    @Test
    @DisplayName("야구게임 숫자는 3자리")
    void numbersAre3Digits() {
        assertThat(testBalls.size()).isEqualTo(3);

    }


}
