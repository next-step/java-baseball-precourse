package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ScoreTest {

    @DisplayName("점수 문자를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2"})
    void text(int strike, int ball) {
        Score score = new Score(new Strike(strike), new Ball(ball), new Nothing());
        String text = score.getText();
        assertThat(text).isEqualTo(Rule.STRIKE.getText(strike)+ " " + Rule.BALL.getText(ball));
    }

    @DisplayName("볼이 없는 경우 스트라이크만 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void strike(int count) {
        Score score = new Score(new Strike(count), new Ball(0), new Nothing());
        String text = score.getText();
        assertThat(text).isEqualTo(Rule.STRIKE.getText(count));
    }

    @DisplayName("스트라이크가 없는 경우 볼만 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void ball(int count) {
        Score score = new Score(new Strike(0), new Ball(count), new Nothing());
        String text = score.getText();
        assertThat(text).isEqualTo(Rule.BALL.getText(count));
    }

    @DisplayName("스트라이크와 볼이 없는 경우 나싱만 생성한다")
    @Test
    void nothing() {
        Score score = new Score(new Strike(0), new Ball(0), new Nothing());
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> score.getText());
    }
}