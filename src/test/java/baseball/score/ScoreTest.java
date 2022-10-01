package baseball.score;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreTest {

    @DisplayName("숫자야구 게임의 결과를 출력할 scoreMap이 정상적으로 생성되는지 확인한다.")
    @Test
    void scoreMap() {
        Map<Score, Integer> scoreIntegerMap = Score.scoreMap();
        assertThat(scoreIntegerMap).hasSize(3);
    }
}