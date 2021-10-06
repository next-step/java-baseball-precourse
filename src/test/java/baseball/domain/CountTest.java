package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CountTest {

    @DisplayName("게임 추측 결과를 저장하는 Count 객체를 생성할 수 있다.")
    @Test
    void create() {
        assertDoesNotThrow(
            () -> new Count(0, 0)
        );
    }

    @DisplayName("올바르지 않은 스트라이크, 볼 갯수로 Count 객체를 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 4})
    void createInvalid(final int value) {
        assertThatThrownBy(
            () -> new Count(value, value)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("동등성을 비교할 수 있다.")
    @Test
    void equals() {
        final Count a = new Count(1, 2);
        final Count b = new Count(1, 2);

        assertThat(a).isEqualTo(b);
    }

    @DisplayName("낫싱")
    @Test
    void nothing() {
        final Count count = createCount(0, 0);
        assertThat(count.toString()).isEqualTo("낫싱");
    }

    @DisplayName("1스트라이크")
    @Test
    void oneStrike() {
        final Count count = createCount(1, 0);
        assertThat(count.toString()).isEqualTo("1스트라이크");
    }

    @DisplayName("2스트라이크")
    @Test
    void twoStrikes() {
        final Count count = createCount(2, 0);
        assertThat(count.toString()).isEqualTo("2스트라이크");
    }

    @DisplayName("3스트라이크")
    @Test
    void threeStrikes() {
        final Count count = createCount(3, 0);
        assertThat(count.toString()).isEqualTo("3스트라이크");
    }

    @DisplayName("1볼")
    @Test
    void oneBall() {
        final Count count = createCount(0, 1);
        assertThat(count.toString()).isEqualTo("1볼");
    }

    @DisplayName("2볼")
    @Test
    void twoBalls() {
        final Count count = createCount(0, 2);
        assertThat(count.toString()).isEqualTo("2볼");
    }

    @DisplayName("3볼")
    @Test
    void threeBalls() {
        final Count count = createCount(0, 3);
        assertThat(count.toString()).isEqualTo("3볼");
    }

    @DisplayName("1스트라이크 1볼")
    @Test
    void oneStrikeOneBall() {
        final Count count = createCount(1, 1);
        assertThat(count.toString()).isEqualTo("1스트라이크 1볼");
    }

    @DisplayName("1스트라이크 2볼")
    @Test
    void oneStrikeTwoBalls() {
        final Count count = createCount(1, 2);
        assertThat(count.toString()).isEqualTo("1스트라이크 2볼");
    }

    private Count createCount(final int numberOfStrikes, final int numberOfBalls) {
        return new Count(numberOfStrikes, numberOfBalls);
    }
}
