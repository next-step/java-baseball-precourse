package baseball.modelTest;

import baseball.model.BaseballGame;
import baseball.model.BaseballComputer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class BaseballGameTest {
    private BaseballGame baseballGame;
    private BaseballComputer baseballComputer;

    @BeforeEach
    void setup(){
        baseballComputer = new BaseballComputer();
        baseballGame = new BaseballGame(baseballComputer);
    }

    @Test
    void 게임엔드(){
        baseballGame.endGame();
        assertThat(baseballGame.getGamestatus()=="end");
    }
}
