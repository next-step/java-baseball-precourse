package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameResultTest {

    @ParameterizedTest
    @CsvSource(value = {"1:2:1", "1:0:1"}, delimiter = ':')
    void 게임결과의_스트라이크_개수_정상_조회(int strike, int ball, int expectStrike) {
        GameResult gameResult = new GameResult(strike, ball);
        assertThat(gameResult.getStrike()).isEqualTo(expectStrike);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:2", "1:0:0"}, delimiter = ':')
    void 게임결과의_볼_개수_정상_조회(int strike, int ball, int expectBall) {
        GameResult gameResult = new GameResult(strike, ball);
        assertThat(gameResult.getBall()).isEqualTo(expectBall);
    }
}