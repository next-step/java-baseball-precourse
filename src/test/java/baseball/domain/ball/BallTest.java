package baseball.domain.ball;

import baseball.exception.BaseBallException.InvalidBallRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static baseball.constant.Rule.MAX_BALL_NUMBER;
import static baseball.constant.Rule.MIN_BALL_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("야구게임 숫자 테스트")
class BallTest {

    @ParameterizedTest(name = "1이상 9이하 범위내 야구게임 숫자 생성 테스트")
    @ValueSource(ints = {1, 5, 9})
    void 범위내_야구게임_숫자_생성_테스트(int input) {
        // when
        Ball ball = new Ball(input);

        // then
        assertThat(ball.getNumber()).isGreaterThanOrEqualTo(MIN_BALL_NUMBER).isLessThanOrEqualTo(MAX_BALL_NUMBER);
    }

    @ParameterizedTest(name = "범위 초과시 예외발생 테스트")
    @ValueSource(ints = {0, 10, -1})
    void 범위초과시_예외발생_테스트(int input) {
        // when + then
        assertThatThrownBy(() -> new Ball(input)).isInstanceOf(InvalidBallRangeException.class);
    }

}