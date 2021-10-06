package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

    @DisplayName("게임을 생성할 수 있다.")
    @Test
    void create() {
        assertDoesNotThrow(Game::new);
    }
}
