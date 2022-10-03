package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BallCountTypeTest {

    @DisplayName("BallCountType 동일 인스턴스에서 스트라이크 수를 전달할 경우 n스트라이크가 반환된다.")
    @ParameterizedTest(name = "{displayName}")
    @CsvSource(value = {"2:2스트라이크", "1:1스트라이크"}, delimiter = ':')
    void countWithStrike(int count, String output) {
        // given & when
        String ballCount = BallCountType.STRIKE.count(count);

        // then
        assertTrue(ballCount.equals(output));
    }

    @DisplayName("BallCountType 동일 인스턴스에서 볼 수를 전달할 경우 n볼이 반환된다.")
    @ParameterizedTest(name = "{displayName}")
    @CsvSource(value = {"2:2볼", "1:1볼"}, delimiter = ':')
    void countWithBall(int count, String output) {
        // given & when
        String ballCount = BallCountType.BALL.count(count);

        // then
        assertTrue(ballCount.equals(output));
    }

    @DisplayName("BallCountType의 toString 메서드는 typeName을 그대로 출력한다.")
    @Test
    void printBallCountTypeName() {
        // given & when
        String ballCount = BallCountType.NOTHING.toString();

        // then
        assertTrue(ballCount.equals("낫싱"));
    }
}