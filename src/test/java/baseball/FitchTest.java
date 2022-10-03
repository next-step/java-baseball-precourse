package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FitchTest {
    @Test
    @DisplayName("test Ftich class has three random number")
    void fitch_hasListSizeThree() {
        Fitch fitch = new Fitch();

        assertEquals(fitch.getFitches().size(), 3);
    }

    @Test
    @DisplayName("test when pass three strike number then return three strike")
    void countBallAndStrike_passThreeStrikeNumberThenReturnThreeStrike() {
        Fitch fitch = new Fitch();
        fitch.setTestFitches();

        Map<String, Integer> ballStrikeCountMap = fitch.countBallAndStrike("418");
        Map<String, Integer> expectBallStrikeCountMap = new HashMap<>();
        expectBallStrikeCountMap.put("strike", 3);
        assertEquals(ballStrikeCountMap, expectBallStrikeCountMap);
    }
}