package baseball.pitching;

import baseball.ball.domain.Ball;
import baseball.ball.domain.BallLocation;
import baseball.ball.domain.BallNumber;
import baseball.common.CharUtils;
import baseball.pitching.domain.Pitching;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("투구")
class PitchingTest {

    @DisplayName("투구를 생성한다.")
    @ParameterizedTest
    @MethodSource("success")
    void createPitching(char[] inputNumber) {
        Pitching pitching = new Pitching();
        for (char number : inputNumber) {
            pitching.add(new Ball(new BallNumber(CharUtils.convertBigDecimal(number)), new BallLocation(BigDecimal.valueOf(pitching.pitchingBalls().size() + 1))));
        }
        assertThat(pitching.pitchingBalls().size()).isEqualTo(3);
    }

    @DisplayName("투구 숫자가 같을 경우 추가할 수 없다.")
    @Test
    void createDuplicateBallNumber() {
        Pitching pitching = new Pitching();
        Ball firstBall = new Ball(new BallNumber(BigDecimal.ONE), new BallLocation(BigDecimal.ONE));
        Ball secondBall = new Ball(new BallNumber(BigDecimal.ONE), new BallLocation(BigDecimal.valueOf(2)));
        pitching.add(firstBall);
        assertThatThrownBy(() -> pitching.add(secondBall))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("투구 숫자가 중복입니다.");
    }

    @DisplayName("투구 위치가 같을 경우 추가할 수 없다.")
    @Test
    void createDuplicateBallLocation() {
        Pitching pitching = new Pitching();
        Ball firstBall = new Ball(new BallNumber(BigDecimal.ONE), new BallLocation(BigDecimal.ONE));
        Ball secondBall = new Ball(new BallNumber(BigDecimal.valueOf(2)), new BallLocation(BigDecimal.ONE));
        pitching.add(firstBall);
        assertThatThrownBy(() -> pitching.add(secondBall))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("투구 위치가 중복입니다.");
    }

    @DisplayName("4개 이상의 투구를 추가할 수 없다.")
    @Test
    void maxBallSize() {
        Pitching pitching = new Pitching();
        pitching.add(new Ball(new BallNumber(BigDecimal.ONE), new BallLocation(BigDecimal.ONE)));
        pitching.add(new Ball(new BallNumber(BigDecimal.valueOf(2)), new BallLocation(BigDecimal.valueOf(2))));
        pitching.add(new Ball(new BallNumber(BigDecimal.valueOf(3)), new BallLocation(BigDecimal.valueOf(3))));
        assertThatThrownBy(() -> pitching.add(new Ball(new BallNumber(BigDecimal.valueOf(4)), new BallLocation(BigDecimal.valueOf(3)))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("투구 영역에 4개 이상의 투구를 추가할 수 업습니다.");
    }

    private static Stream<char[]> success() {
        return Stream.of(
                "123".toCharArray(),
                "456".toCharArray()
        );
    }

}
