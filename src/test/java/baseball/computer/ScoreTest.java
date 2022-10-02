package baseball.computer;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest {

    @Test
    void equals() {
        Score source = new Score(1,1);
        Score input = new Score(1,1);
        assertThat(source.equals(input)).isTrue();
    }

    @Test
    void equalsScore() {
        Score source = new Score(1,1);
        Score input = new Score(1,2);
        assertThat(source.equals(input)).isFalse();
        assertThat(source.equalsScore(input.getScore())).isTrue();
    }
}
