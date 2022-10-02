package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ScoreTest {
    @Test
    void toString_낫싱_테스트() {
        Score score = new Score(0, 0);
        assertThat(score.toString()).isEqualTo("낫싱");
    }

    @Test
    void toString_1볼_테스트() {
        Score score = new Score(1, 0);
        assertThat(score.toString()).isEqualTo("1볼");
    }

    @Test
    void toString_1스트라이크_테스트() {
        Score score = new Score(0, 1);
        assertThat(score.toString()).isEqualTo("1스트라이크");
    }


    @Test
    void toString_1볼_1스트라이크_테스트() {
        Score score = new Score(1, 1);
        assertThat(score.toString()).isEqualTo("1볼 1스트라이크");
    }
}
