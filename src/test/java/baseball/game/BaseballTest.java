package baseball.game;

import baseball.computer.ScoreBag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballTest {

    @Test
    void play_match() {
        int[] scores = {1,2,3};
        ScoreBag source = ScoreBag.makeScoreBag(scores);
        ScoreBag input = ScoreBag.makeScoreBag(scores);
        BaseBall baseBall = new BaseBall();
        boolean result = baseBall.play(source, input);
        assertThat(result).isTrue();
    }

    @Test
    void play_not_match() {
        int[] sourceScore = {1,2,3};
        int[] inputScore = {1,2,4};
        ScoreBag source = ScoreBag.makeScoreBag(sourceScore);
        ScoreBag input = ScoreBag.makeScoreBag(inputScore);
        BaseBall baseBall = new BaseBall();
        boolean result = baseBall.play(source, input);
        assertThat(result).isFalse();
    }
}
