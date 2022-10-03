package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player(new Ball());
    }

    /* 입력 로직 제외 */
    @ParameterizedTest
    @DisplayName("플레이어가 정수인 잘못된 값을 입력한다.")
    @ValueSource(strings = {"1", "12","1234"})
    void validateInputBallNumber(int input) {
        assertThatThrownBy(() -> {
            player.validateInputBallNumber(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값")
                .hasMessageContaining("정수");


        assertThatThrownBy(() -> {
            player.validateInputBallNumber(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값")
                .hasMessageContaining("정수");
    }
}
