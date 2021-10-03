package baseball;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallGameManagerTest {

    @Test
    public void isFinished_game_test() {
        BaseBallGameManager baseBallGameManager = new BaseBallGameManager(123);
        baseBallGameManager.checkUserAnswer("123");
        assertThat(baseBallGameManager.isFinished()).isEqualTo(true);
    }
}