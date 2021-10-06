package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.enums.MATCH_RESULT;

public class BallTest {

    private Ball ball;

    @BeforeEach
    void setup() {
        ball = new Ball(3, 1);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,1,STRIKE", "3,2,BALL", "4,1,NOTHING", "5,2,NOTHING"}, delimiter = ',')
    void 하나의_공이_주어질_경우_스트라이크_볼_낫싱_여부를_판단한다(int ballNumber, int location, MATCH_RESULT expected) {
        Assertions.assertThat(ball.match(new Ball(ballNumber, location))).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 6, 9})
    void 공의_번호가_1_에서_9_사이의_값이면_Ball_객체_생성시_예외가_발생하지_않는다(int ballNumber) {
        Assertions.assertThatNoException().isThrownBy(() -> new Ball(ballNumber, 0));
    }
}
