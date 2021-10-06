package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

    private Game game;
    private Number answer;

    @BeforeEach
    void setUp() {
        answer = new Number("123");
        game = new Game(answer);
    }

    @DisplayName("게임을 생성할 수 있다.")
    @Test
    void create() {
        assertDoesNotThrow(
            () -> new Game(answer)
        );
    }

    @DisplayName("게임의 정답은 null이 될 수 없다.")
    @Test
    void createWithNullAnswer() {
        assertThatThrownBy(
            () -> new Game(null)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임의 정답을 추측할 수 있다 (성공).")
    @Test
    void guessSuccess() {
        final Number guess = new Number("123");
        assertThat(game.guess(guess)).isTrue();
    }

    @DisplayName("게임의 정답을 추측할 수 있다 (실패).")
    @Test
    void guessFail() {
        final Number guess = new Number("456");
        assertThat(game.guess(guess)).isFalse();
    }
}
