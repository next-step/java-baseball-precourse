package baseball.domain.result;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void 스트라이크_테스트() {
        List<Score> scores = new ArrayList<>();
        scores.add(Score.STRIKE);
        scores.add(Score.STRIKE);
        scores.add(Score.STRIKE);

        Result result = Result.from(scores);
        assertAll(
            () -> assertThat(result.isVictory()).isTrue(),
            () -> assertThat(result.isNothing()).isFalse(),
            () -> assertThat(result.getStrike()).isEqualTo(3),
            () -> assertThat(result.getBall()).isZero()
        );
    }

    @Test
    void 볼_테스트() {
        List<Score> scores = new ArrayList<>();
        scores.add(Score.BALL);
        scores.add(Score.BALL);
        scores.add(Score.BALL);

        Result result = Result.from(scores);
        assertAll(
            () -> assertThat(result.isVictory()).isFalse(),
            () -> assertThat(result.isNothing()).isFalse(),
            () -> assertThat(result.getStrike()).isZero(),
            () -> assertThat(result.getBall()).isEqualTo(3)
        );
    }

    @Test
    void 낫싱_테스트() {
        List<Score> scores = new ArrayList<>();
        scores.add(Score.MISS);
        scores.add(Score.MISS);
        scores.add(Score.MISS);

        Result result = Result.from(scores);
        assertAll(
            () -> assertThat(result.isVictory()).isFalse(),
            () -> assertThat(result.isNothing()).isTrue(),
            () -> assertThat(result.getStrike()).isZero(),
            () -> assertThat(result.getBall()).isZero()
        );
    }
}
