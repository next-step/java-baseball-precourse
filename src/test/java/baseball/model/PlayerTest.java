package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {
    @Test
    @DisplayName("1부터 9까지의 3자리의 숫자만 입력가능")
    void allow_3_digit_from_1_to_9_test() {
        // given
        String regex = "[1-9]{3}";

        // when
        String right_value = "123";
        String wrong_value = "012";

        // then
        assertThat(right_value).matches(regex);
        assertThat(wrong_value).doesNotMatch(regex);
    }

    @ParameterizedTest
    @DisplayName("플레이어가 잘못된 값을 입력시 IllegalArgumentException 발생")
    @ValueSource(strings = {"111", "012", "ase", "a21", " 19", "1234"})
    void invalid_value_throw_exception_test (String values) {
        // given
        // when
        Player player = new Player();
        
        // then
        assertThatThrownBy(() -> player.inputBalls(values))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 값을 입력하였습니다. 게임을 종료합니다.");
    }
}