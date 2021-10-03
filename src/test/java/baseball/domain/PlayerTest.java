package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Player Domain Test")
class PlayerTest {

    @DisplayName("Player 생성자 Test")
    @Test
    public void initPlayerTest() {
        Player player = new Player();
        BaseballNumber baseballNumber = new BaseballNumber(473);
        player.setBaseballNumber(baseballNumber);
        assertNotNull(player);
        assertNotNull(player.getBaseballNumber());
        assertEquals("473", player.getBaseballNumber().numberToString());
    }
}