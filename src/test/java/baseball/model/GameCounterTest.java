package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameCounterTest {

    private GameCounter gameCounter;
    private List<Integer> gameNumbers;

    @BeforeEach
    void setUp() {
        gameCounter = new GameCounter();
        gameNumbers = new LinkedList<>(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("카운터 계산 결과: 3스트라이크")
    void threeStrike() {
        // given
        List<Integer> userNumbers = new LinkedList<>(Arrays.asList(1, 2, 3));

        // when
        gameCounter.calculate(gameNumbers, userNumbers);

        // then
        assertThat(gameCounter.isNothing()).isFalse();
        assertThat(gameCounter.hasBall()).isFalse();
        assertThat(gameCounter.getBall()).isEqualTo(0);
        assertThat(gameCounter.hasStrike()).isTrue();
        assertThat(gameCounter.getStrike()).isEqualTo(3);

    }

    @Test
    @DisplayName("카운터 계산 결과: 2볼 1스트라이크")
    void oneBallTwoStrike() {
        // given
        List<Integer> userNumbers = new LinkedList<>(Arrays.asList(2, 1, 3));

        // when
        gameCounter.calculate(gameNumbers, userNumbers);

        // then
        assertThat(gameCounter.isNothing()).isFalse();
        assertThat(gameCounter.hasBall()).isTrue();
        assertThat(gameCounter.getBall()).isEqualTo(2);
        assertThat(gameCounter.hasStrike()).isTrue();
        assertThat(gameCounter.getStrike()).isEqualTo(1);

    }

    @Test
    @DisplayName("카운터 계산 결과: Nothing")
    void nothing() {
        // given
        List<Integer> userNumbers = new LinkedList<>(Arrays.asList(4, 5, 6));

        // when
        gameCounter.calculate(gameNumbers, userNumbers);

        // then
        assertThat(gameCounter.isNothing()).isTrue();
        assertThat(gameCounter.hasBall()).isFalse();
        assertThat(gameCounter.getBall()).isEqualTo(0);
        assertThat(gameCounter.hasStrike()).isFalse();
        assertThat(gameCounter.getStrike()).isEqualTo(0);

    }
}