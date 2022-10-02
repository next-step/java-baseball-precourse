package baseball.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {


    @Test
    public void 게임결과테스트(){
        GameResult gameResult = new GameResult(2, 1);

        String expected = "1볼 2스트라이크";


        assertEquals(expected, gameResult.toString());
    }


}