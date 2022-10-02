package baseball.computer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreBagTest {

    @Test
    void initTest() {
        ScoreBag scoreBag = new ScoreBag();
        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < scoreBag.getScores().size(); i++) {
            scores.add(scoreBag.getScores().get(i).getScore());
        }
        assertThat(scores).containsAnyOf(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    void makeScoreBag() {
        int[] inputScore = {1,3,5};
        ScoreBag scoreBag = ScoreBag.makeScoreBag(inputScore);
        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < scoreBag.getScores().size(); i++) {
            scores.add(scoreBag.getScores().get(i).getScore());
        }
        assertThat(scores).containsOnly(1,3,5);
    }
}
