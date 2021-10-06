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

    @DisplayName("게임의 정답을 추측할 수 있다: 낫싱")
    @Test
    void guessNothing() {
        final Number guess = new Number("456");
        final Count count = new Count(0, 0);

        assertThat(game.guess(guess)).isEqualTo(count);
    }

    @DisplayName("게임의 정답을 추측할 수 있다: 1스트라이크")
    @ParameterizedTest
    @ValueSource(strings = {"145", "425", "453"})
    void guessOneStrike(final String value) {
        final Number guess = new Number(value);
        final Count count = new Count(1, 0);

        assertThat(game.guess(guess)).isEqualTo(count);
    }

    @DisplayName("게임의 정답을 추측할 수 있다: 2스트라이크")
    @ParameterizedTest
    @ValueSource(strings = {"125", "523", "153"})
    void guessTwoStrikes(final String value) {
        final Number guess = new Number(value);
        final Count count = new Count(2, 0);

        assertThat(game.guess(guess)).isEqualTo(count);
    }

    @DisplayName("게임의 정답을 추측할 수 있다: 3스트라이크")
    @Test
    void guessThreeStrikes() {
        final Number guess = new Number("123");
        final Count count = new Count(3, 0);

        assertThat(game.guess(guess)).isEqualTo(count);
    }

    @DisplayName("게임의 정답을 추측할 수 있다: 1볼")
    @ParameterizedTest
    @ValueSource(strings = {"415", "451", "254", "452", "345", "435"})
    void guessOneBall(final String value) {
        final Number guess = new Number(value);
        final Count count = new Count(0, 1);

        assertThat(game.guess(guess)).isEqualTo(count);
    }

    @DisplayName("게임의 정답을 추측할 수 있다: 2볼")
    @ParameterizedTest
    @ValueSource(strings = {"214", "341", "432", "234", "412"})
    void guessTwoBalls(final String value) {
        final Number guess = new Number(value);
        final Count count = new Count(0, 2);

        assertThat(game.guess(guess)).isEqualTo(count);
    }

    @DisplayName("게임의 정답을 추측할 수 있다: 3볼")
    @ParameterizedTest
    @ValueSource(strings = {"312", "231"})
    void guessThreeBalls(final String value) {
        final Number guess = new Number(value);
        final Count count = new Count(0, 3);

        assertThat(game.guess(guess)).isEqualTo(count);
    }

    @DisplayName("게임의 정답을 추측할 수 있다: 1스트라이크 1볼")
    @ParameterizedTest
    @ValueSource(strings = {"135", "152", "325", "513"})
    void guessOneStrikeOneBall(final String value) {
        final Number guess = new Number(value);
        final Count count = new Count(1, 1);

        assertThat(game.guess(guess)).isEqualTo(count);
    }

    @DisplayName("게임의 정답을 추측할 수 있다: 1스트라이크 2볼")
    @ParameterizedTest
    @ValueSource(strings = {"132", "321", "213"})
    void guessOneStrikeTwoBalls(final String value) {
        final Number guess = new Number(value);
        final Count count = new Count(1, 2);

        assertThat(game.guess(guess)).isEqualTo(count);
    }
}
