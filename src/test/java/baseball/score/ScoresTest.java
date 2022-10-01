package baseball.score;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ScoresTest {

    @DisplayName("결과값을 생성하는 Scores 인스턴스를 생성하여 입력받은 List<Score> 값을 Map<Score, Integer> 형태로 Score 갯수를 잘 세는지 확인한다.")
    @Test
    void construct() {
        List<Score> scoreList = new ArrayList<>();
        scoreList.add(Score.STRIKE);
        scoreList.add(Score.BALL);
        scoreList.add(Score.STRIKE);

        Scores scores = new Scores(scoreList);
        Map<Score, Integer> scoreIntegerMap = scores.getScoreIntegerMap();

        assertAll(
                () -> assertThat(scoreIntegerMap.get(Score.STRIKE)).isEqualTo(2),
                () -> assertThat(scoreIntegerMap.get(Score.BALL)).isEqualTo(1),
                () -> assertThat(scoreIntegerMap.get(Score.NOTHING)).isEqualTo(0)
        );
    }
}