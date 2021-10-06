package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreTest {

    private Score score;

    @BeforeEach
    void setUp() {
        score = new Score(Rule.STRIKE, Rule.BALL, Rule.NOTHING);
    }

    @DisplayName("점수 문자를 생성한다.")
    @Test
    void text() {
        String text = score.getText(1, 2);
        assertThat(text).isEqualTo("1스트라이크 2볼");
    }

    @DisplayName("볼이 없는 경우 스트라이크만 생성한다.")
    @Test
    void text_strike() {
        String text = score.getText(3, 0);
        assertThat(text).isEqualTo("3스트라이크");
    }

    @DisplayName("스트라이크가 없는 경우 볼만 생성한다.")
    @Test
    void text_ball() {
        String text = score.getText(0, 2);
        assertThat(text).isEqualTo("2볼");
    }

    @DisplayName("스트라이크와 볼이 없는 경우 나싱만 생성한다")
    @Test
    void text_nothing() {
        String text = score.getText(0, 0);
        assertThat(text).isEqualTo("나싱");
    }
}