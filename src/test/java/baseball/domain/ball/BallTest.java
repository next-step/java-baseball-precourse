package baseball.domain.ball;

import baseball.exception.BaseballException.InvalidRangeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static baseball.constant.Rule.*;
import static baseball.domain.score.ScoreType.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("야구게임 숫자 테스트")
class BallTest {

    Ball ball;

    @BeforeEach
    void setUp() {
        ball = new Ball(3, 1);
    }

    @Test
    void 범위내_야구게임_숫자_생성_테스트() {
        // then
        assertThat(ball.getNumber()).isGreaterThanOrEqualTo(MIN_BALL_NUMBER).isLessThanOrEqualTo(MAX_BALL_NUMBER);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,1", "5,-2", "9,4"})
    void 범위초과시_예외발생_테스트(int number, int position) {
        // when + then
        assertThatThrownBy(() -> new Ball(number, position)).isInstanceOf(InvalidRangeException.class);
    }

    @Test
    void 비교_테스트() {
        // given
        Ball strikeBall = new Ball(3, 1);
        Ball ballBall = new Ball(3, 2);
        Ball nothingBall = new Ball(4, 1);

        // when + then
        assertThat(ball.compare(strikeBall)).isEqualTo(STRIKE);
        assertThat(ball.compare(ballBall)).isEqualTo(BALL);
        assertThat(ball.compare(nothingBall)).isEqualTo(NOTHING);
    }

}