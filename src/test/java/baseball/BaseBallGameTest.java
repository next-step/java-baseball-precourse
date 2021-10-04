package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseBallGameTest {

    private BaseBallGame baseBallGame;

    @BeforeEach
    void setUp() {
        baseBallGame = new BaseBallGame(BaseBallGame.DEFAULT_LENGTH);
    }
}
