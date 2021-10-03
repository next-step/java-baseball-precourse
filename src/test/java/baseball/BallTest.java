package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallTest {

    private Ball ball;

    @BeforeEach
    void setup(){
        ball = new Ball(1, 3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,3,STRIKE", "2,3,BALL", "1,4,NOTHING", "2,5,NOTHING"}, delimiter = ',')
    void 하나의_공이_주어질_경우_스트라이크_볼_낫싱_여부를_판단한다(int location, int ballNumber, MATCH_RESULT expected){
        Ball counterBall = new Ball(location, ballNumber);

        Assertions.assertThat(ball.match(counterBall)).isEqualTo(expected);
    }
}
