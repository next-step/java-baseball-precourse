package baseball.domain;

import static baseball.domain.BallStatus.BALL;
import static baseball.domain.BallStatus.NOTHING;
import static baseball.domain.BallStatus.STRIKE;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BallTest {

    @DisplayName("숫자와 위치가 같으면 STRIKE 이다.")
    @ParameterizedTest
    @CsvSource(value = {"1:1:1:1", "1:3:1:3", "9:3:9:3"}, delimiter = ':')
    void isStrike(int inputNumber1, int inputLocation1, int inputNumber2, int inputLocation2) {

        Ball ball1 = new Ball(inputNumber1, inputLocation1);
        Ball ball2 = new Ball(inputNumber2, inputLocation2);

        Assertions.assertThat(ball1.judgeBall(ball2)).isEqualTo(STRIKE);
    }


    @DisplayName("숫자가 같고 위치가 다르면 BALL 이다.")
    @ParameterizedTest
    @CsvSource(value = {"1:1:1:3", "5:3:5:2", "9:3:9:1"}, delimiter = ':')
    void isBall(int inputNumber1, int inputLocation1, int inputNumber2, int inputLocation2) {

        Ball ball1 = new Ball(inputNumber1, inputLocation1);
        Ball ball2 = new Ball(inputNumber2, inputLocation2);

        Assertions.assertThat(ball1.judgeBall(ball2)).isEqualTo(BALL);
    }

    @DisplayName("숫자와 위치가 모두 다르면 NOTHING 이다.")
    @ParameterizedTest
    @CsvSource(value = {"1:1:9:3", "5:3:6:2", "9:3:1:1"}, delimiter = ':')
    void isNothing(int inputNumber1, int inputLocation1, int inputNumber2, int inputLocation2) {

        Ball ball1 = new Ball(inputNumber1, inputLocation1);
        Ball ball2 = new Ball(inputNumber2, inputLocation2);

        Assertions.assertThat(ball1.judgeBall(ball2)).isEqualTo(NOTHING);
    }
}
