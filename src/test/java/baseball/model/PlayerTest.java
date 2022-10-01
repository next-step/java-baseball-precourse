package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {
    @DisplayName("세자리 숫자로 초기화")
    @ParameterizedTest
    @ValueSource(strings = {"123", "234", "345", "456", "567"})
    void 세자리_숫자로_초기화(String input) {
        Player player = new Player();

        assertThatNoException().isThrownBy(() -> player.setNumbers(input));
    }

    @DisplayName("세자리가 아닌 숫자로 초기화")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "1234", "12345", "123456"})
    void 세자리가_아닌_숫자로_초기화(String input) {
        Player player = new Player();

        assertThatThrownBy(() -> player.setNumbers(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 값으로 초기화")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "a", "ab", "Abc", "sdf", "ZXC"})
    void 숫자가_아닌_값으로_초기화(String input) {
        Player player = new Player();

        assertThatThrownBy(() -> player.setNumbers(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
