package baseball.model;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameSystemTest {

    @ParameterizedTest
    @ValueSource(strings = {"ffff", "1234", "11f", "121", "777"})
    @DisplayName("입력받은 숫자 유효성 실패 테스트")
    public void inputNumberValidFailTest(String input) {
        assertThatThrownBy(() -> {
            GameSystem.validateWord(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}