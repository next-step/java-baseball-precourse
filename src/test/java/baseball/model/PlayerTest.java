package baseball.model;

import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    Player player;
    List<Integer> answerNumList;

    @BeforeEach
    void setUp() {
        answerNumList = Lists.newArrayList(1,2,3);
    }

    @Test
    @DisplayName("Player 테스트 :: 3 strike")
    public void playerTest_3strike() {
        player = new Player(new Integer[]{1,2,3}, answerNumList);

        Assertions.assertTrue(player.getBall() == 0);
        Assertions.assertTrue(player.getStrike() == 3);
        Assertions.assertFalse(player.isNothing());
    }

    @Test
    @DisplayName("Player 테스트 :: 2ball")
    public void playerTest_2ball() {
        Player player = new Player(new Integer[]{2,1,4}, answerNumList);

        Assertions.assertTrue(player.getBall() == 2);
        Assertions.assertTrue(player.getStrike() == 0);
        Assertions.assertFalse(player.hasBallAndStrike());
        Assertions.assertTrue(player.hasOnlyBall());
        Assertions.assertFalse(player.hasOnlyStrike());
        Assertions.assertFalse(player.isNothing());
    }

    @Test
    @DisplayName("Player 테스트 :: 2strike")
    public void playerTest_2strike() {
        Player player = new Player(new Integer[]{1,2,4}, answerNumList);

        Assertions.assertTrue(player.getBall() == 0);
        Assertions.assertTrue(player.getStrike() == 2);
        Assertions.assertFalse(player.hasBallAndStrike());
        Assertions.assertFalse(player.hasOnlyBall());
        Assertions.assertTrue(player.hasOnlyStrike());
        Assertions.assertFalse(player.isNothing());
    }

    @Test
    @DisplayName("Player 테스트 :: 1ball 1strike")
    public void playerTest_1ball() {
        Player player = new Player(new Integer[]{1,3,4}, answerNumList);

        Assertions.assertTrue(player.getBall() == 1);
        Assertions.assertTrue(player.getStrike() == 1);
        Assertions.assertFalse(player.isNothing());
    }

    @Test
    @DisplayName("Player 테스트 :: nothing")
    public void playerTest_nothing() {
        player = new Player(new Integer[]{4,5,6}, answerNumList);

        Assertions.assertTrue(player.getBall() == 0);
        Assertions.assertTrue(player.getStrike() == 0);
        Assertions.assertFalse(player.hasBallAndStrike());
        Assertions.assertFalse(player.hasOnlyBall());
        Assertions.assertFalse(player.hasOnlyStrike());
        Assertions.assertTrue(player.isNothing());
    }

}