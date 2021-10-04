package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Balls: Ball 의 묶음, 숫자 리스트를 넘기면 비교해서 스트라이크/볼 갯수가 담긴 CompareResult 반환")
public class BallsTest {

    @DisplayName("비교하려는 두 List 의 크기는 같아야 함")
    @Test
    void validateCompareResult() {
        List<Integer> ballsList = Arrays.asList(1, 2, 3);
        Balls balls = new Balls(ballsList);
        List<Integer> numbers = Arrays.asList(4, 5, 6, 7);

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> balls.compareWith(numbers)
        ).withMessageMatching("비교하려는 두 Balls 의 크기가 다릅니다. 입력값: " + numbers.size() + ", 정답: " + ballsList.size());
    }

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
