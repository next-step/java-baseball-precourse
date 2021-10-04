package baseball.model;

import baseball.model.enums.BallStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Ball 의 묶음으로 다른 숫자 리스트와 비교 가능")
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

    @DisplayName("숫자 리스트를 넘기면 비교해서 스트라이크/볼 갯수가 담긴 CompareResult 반환")
    @Nested
    class CompareWithIntegerList {

        @DisplayName("STRIKE 와 BALL 전부 없음")
        @Test
        void testNoStrikeAndNoBall() {
            Balls balls = new Balls(Arrays.asList(1, 2, 3));

            CompareResult result = balls.compareWith(Arrays.asList(4, 5, 6));

            assertThat(result.getStrikeCount()).isEqualTo(0);
            assertThat(result.getBallCount()).isEqualTo(0);
        }

        @DisplayName("STRIKE 없고 BALL 만 존재")
        @ParameterizedTest
        @CsvSource(value = {
                "2, 4, 5, 1",
                "4, 3, 5, 1",
                "4, 5, 1, 1",
                "2, 1, 4, 2",
                "4, 3, 2, 2",
                "3, 4, 1, 2",
                "3, 1, 2, 3",
                "2, 3, 1, 3",
        })
        void testNoStrike(int a, int b, int c, int ballCount) {
            Balls balls = new Balls(Arrays.asList(1, 2, 3));

            CompareResult result = balls.compareWith(Arrays.asList(a, b, c));

            assertThat(result.getStrikeCount()).isEqualTo(0);
            assertThat(result.getBallCount()).isEqualTo(ballCount);
        }

        @DisplayName("STRIKE 만 있고 BALL 은 없음")
        @ParameterizedTest
        @CsvSource(value = {
                "1, 4, 5, 1",
                "4, 2, 5, 1",
                "4, 5, 3, 1",
                "1, 2, 4, 2",
                "1, 4, 3, 2",
                "4, 2, 3, 2",
                "1, 2, 3, 3"
        })
        void testNoBall(int a, int b, int c, int strikeCount) {
            Balls balls = new Balls(Arrays.asList(1, 2, 3));

            CompareResult result = balls.compareWith(Arrays.asList(a, b, c));

            assertThat(result.getStrikeCount()).isEqualTo(strikeCount);
            assertThat(result.getBallCount()).isEqualTo(0);
        }

        @DisplayName("STRIKE 와 BALL 모두 존재 (2 STRIKE 1 BALL 이라는 경우는 존재하지 않음)")
        @ParameterizedTest
        @CsvSource(value = {
                "1, 3, 2, 1, 2",
                "3, 2, 1, 1, 2",
                "2, 1, 3, 1, 2"
        })
        void testStrikeAndBall(int a, int b, int c, int strikeCount, int ballCount) {
            Balls balls = new Balls(Arrays.asList(1, 2, 3));

            CompareResult result = balls.compareWith(Arrays.asList(a, b, c));

            assertThat(result.getStrikeCount()).isEqualTo(strikeCount);
            assertThat(result.getBallCount()).isEqualTo(ballCount);
        }
    }
}
