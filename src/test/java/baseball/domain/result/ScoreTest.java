package baseball.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ScoreTest {

    private List<Score> scores = new ArrayList<>();

    ScoreTest() {
        scores.add(Score.STRIKE);
        scores.add(Score.BALL);
        scores.add(Score.MISS);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:0", "1:2:1", "1:-1:2"}, delimiter = ':')
    void 올바른_점수를_반환한다(int idx1, int idx2, int expectedStateIdx) {
        Score score = Score.of(idx1, idx2);

        assertThat(score).isEqualTo(getState(expectedStateIdx));
    }

    private Score getState(int idx) {
        return scores.get(idx);
    }
}