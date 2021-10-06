package baseball.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Ball Count 테스트")
class BallCountTest {

    List<Integer> strikeBall;
    List<Integer> strike;
    List<Integer> ball;

    @BeforeEach
    public void setUp() {
        strikeBall = Arrays.asList(1, 1);
        strike = Arrays.asList(1, 0);
        ball = Arrays.asList(0, 1);
    }

    @Test
    @DisplayName("스트라이크 및 볼 값이 동시에 존재할 때 원하는 포맷의 문자열을 반환하는지 확인")
    void checkStrikeBallCountString() {
        // given //when
        BallCount strikeBallCount = new BallCount.Builder()
                .strike(strikeBall.get(0))
                .ball(strikeBall.get(1))
                .build();

        // then
        assertAll(
                () -> assertThat(strikeBallCount.getStrike()).isEqualTo(1),
                () -> assertThat(strikeBallCount.getBall()).isEqualTo(1),
                () -> assertThat(strikeBallCount.generateBallCountString()).isEqualTo("1스트라이크 1볼")
        );
    }

    @Test
    @DisplayName("스트라이크 값만 존재할 때 원하는 포맷의 문자열을 반환하는지 확인")
    void checkStrikeCountString() {
        // given //when
        BallCount strikeCount = new BallCount.Builder()
                .strike(strike.get(0))
                .ball(strike.get(1))
                .build();

        // then
        assertAll(
                () -> assertThat(strikeCount.getStrike()).isEqualTo(1),
                () -> assertThat(strikeCount.getBall()).isEqualTo(0),
                () -> assertThat(strikeCount.generateBallCountString()).isEqualTo("1스트라이크")
        );
    }

    @Test
    @DisplayName("스트라이크 값만 존재할 때 원하는 포맷의 문자열을 반환하는지 확인")
    void checkBallCountString() {
        // given // when
        BallCount ballCount = new BallCount.Builder()
                .strike(ball.get(0))
                .ball(ball.get(1))
                .build();

        // then
        assertAll(
                () -> assertThat(ballCount.getStrike()).isEqualTo(0),
                () -> assertThat(ballCount.getBall()).isEqualTo(1),
                () -> assertThat(ballCount.generateBallCountString()).isEqualTo("1볼")
        );
    }
}
