package baseball.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void createPlayerTest() {
        Player testPlayer = new Player();
        Assertions.assertEquals(testPlayer.getClass(), Player.class);
    }

    @Test
    void setPlayerNumberTest() {
        Player testPlayer = new Player();
        List<Integer> testIntegerList = Arrays.asList(1, 2, 3);
        testPlayer.setNumbers(testIntegerList);
        Assertions.assertEquals(testPlayer.getNumbers(), testIntegerList);
    }
}
