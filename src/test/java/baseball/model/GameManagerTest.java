package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameManagerTest {
    GameManager gameManager;

    @BeforeEach
    public void setUp() {
        gameManager = new GameManager("1");
    }

    @Test
    @DisplayName("유효한 숫자인지 체크하는 예외 발생 테스트")
    public void validCheckGameStatusNumberTest() {
        // Given
        String gameStatusErrorNumber;

        // When
        gameStatusErrorNumber = "3";

        // Then
        assertThatThrownBy(() -> gameManager.validCheckGameStatusNumber(gameStatusErrorNumber))
                .isInstanceOf(IllegalArgumentException.class)
        ;
    }
}