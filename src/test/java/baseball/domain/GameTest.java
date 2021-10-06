package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game("123");
    }

    @DisplayName("게임을 생성할 수 있다.")
    @Test
    void create() {
        assertDoesNotThrow(
            () -> new Game("123")
        );
    }

    @DisplayName("1부터 9까지 서로 다른 수로 이루어진 3자리의 수 외 다른 숫자를 게임의 정답으로 지정할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "a", "1", "12", "1234", "012", "102", "120", "112", "122", "111"})
    void createWithInvalidAnswer(final String answer) {
        assertThatThrownBy(
            () -> new Game(answer)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임의 정답을 추측할 수 있다 (성공).")
    @Test
    void guessSuccess() {
        assertThat(game.guess("123")).isTrue();
    }

    @DisplayName("게임의 정답을 추측할 수 있다 (실패).")
    @Test
    void guessFail() {
        assertThat(game.guess("456")).isFalse();
    }

    @DisplayName("1부터 9까지 서로 다른 수로 이루어진 3자리의 수 외 다른 숫자를 게임의 정답을 추측할 때 사용할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "a", "1", "12", "1234", "012", "102", "120", "112", "122", "111"})
    void guessWithInvalidNumber(final String guess) {
        assertThatThrownBy(
            () -> game.guess(guess)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
