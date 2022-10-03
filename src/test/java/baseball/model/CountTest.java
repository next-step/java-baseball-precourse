package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CountTest {

    @DisplayName("getBall isEquals 케이스")
    @Test
    void getBallTest() {
        Count count = new Count(3, 0);

        assertThat(count.getBall()).isEqualTo(3);
    }

    @DisplayName("getBall isEquals 케이스")
    @Test
    void getStrikeTest() {
        Count count = new Count(0, 3);

        assertThat(count.getStrike()).isEqualTo(3);
    }

    @DisplayName("isNothing true 케이스")
    @Test
    void isNothingTrueTest() {
        Count count = new Count(0, 0);

        assertThat(count.isNothing()).isTrue();
    }

    @DisplayName("isNothing false 케이스")
    @Test
    void isNothingFalseTest() {
        Count count = new Count(2, 1);

        assertThat(count.isNothing()).isFalse();
    }
}
