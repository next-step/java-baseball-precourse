package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CompareBallsTest {

    @ParameterizedTest
    @CsvSource(value = {"123:456:0", "123:123:3","123:453:1", "123:123:3"}, delimiter = ':')
    @DisplayName("스트라이크 갯수를 제대로 체크하는지 테스트")
    void countStrikes(String computerBalls, String playerBalls, Integer expected) {
        assertThat(CompareBalls.countStrikes(computerBalls, playerBalls)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"123:456:0", "123:123:0","123:345:1","123:312:3"}, delimiter = ':')
    @DisplayName("볼 갯수를 제대로 체크하는지 테스트")
    void countBalls(String computerBalls, String playerBalls, Integer expected) {
        assertThat(CompareBalls.countBalls(computerBalls, playerBalls)).isEqualTo(expected);
    }

}