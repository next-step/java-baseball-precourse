package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("게임결과 Domain Test")
class GameResultTest {

    @DisplayName("스트라이크 개수 추가 Test")
    @Test
    void addStrikeTest() {
        GameResult gameResult = new GameResult();
        assertEquals(0, gameResult.getStrike());
        gameResult.addStrike();
        assertEquals(1, gameResult.getStrike());
    }

    @DisplayName("볼 개수 추가 Test")
    @Test
    void addBall() {
        GameResult gameResult = new GameResult();
        assertEquals(0, gameResult.getBall());
        gameResult.addBall();
        assertEquals(1, gameResult.getBall());
    }
}