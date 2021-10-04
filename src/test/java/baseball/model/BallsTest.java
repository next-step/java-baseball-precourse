package baseball.model;

import baseball.model.enums.BallStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {

    @DisplayName("공 하나와 비교")
    @Nested
    class CompareWithBall {

        @DisplayName("공의 숫자가 매칭되는게 전혀 없으면 NONE")
        @Test
        void testOneBallIsNONE() {
            Balls balls = new Balls(Arrays.asList(1, 2, 3));
            Ball ball = new Ball(1, 9);

            BallStatus status = balls.compareWith(ball);

            assertThat(status).isEqualTo(BallStatus.NONE);
        }

        @DisplayName("공의 위치는 다르지만 숫자가 같은게 하나라도 있으면 BALL")
        @ParameterizedTest
        @CsvSource(value = {
                "3, 1",
                "3, 2",
                "3, 3"
        })
        void testOneBallIsBALL(int position, int number) {
            Balls balls = new Balls(Arrays.asList(1, 2, 3));
            Ball ball = new Ball(position, number);

            BallStatus status = balls.compareWith(ball);

            assertThat(status).isEqualTo(BallStatus.BALL);
        }

        @DisplayName("공의 위치와 숫자가 같으면 있으면 STRIKE")
        @ParameterizedTest
        @CsvSource(value = {
                "0, 1",
                "1, 2",
                "2, 3"
        })
        void testOneBallIsSTRIKE(int position, int number) {
            Balls balls = new Balls(Arrays.asList(1, 2, 3));
            Ball ball = new Ball(position, number);

            BallStatus status = balls.compareWith(ball);

            assertThat(status).isEqualTo(BallStatus.STRIKE);
        }
    }
}
