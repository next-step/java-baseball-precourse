package baseball.ball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author KingCjy
 */
class BallCountTest {
    @ParameterizedTest
    @CsvSource(value = {"0:0:낫싱", "2:0:2스트라이크", "0:1:1볼", "2:1:2스트라이크 1볼"}, delimiter = ':')
    @DisplayName("결과값에 따른 메세지 테스트")
    public void getMessageTest(int strike, int ball, String message) {
        List<Score> scores = new ArrayList<>();

        for (int i = 0; i < strike; i++) {
            scores.add(Score.STRIKE);
        }

        for (int i = 0; i < ball; i++) {
            scores.add(Score.BALL);
        }

        assertThat(new BallCount(scores).getMessage()).isEqualTo(message);
    }
}