package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseBallGameNumberComparatorTest {

    private BaseBallGameNumberComparator baseBallGameNumberComparator;

    @BeforeEach
    void setUp() {
        baseBallGameNumberComparator = new BaseBallGameNumberComparator(BaseBallGame.DEFAULT_LENGTH);
    }

    @Test
    public void 스트라이크_3개() {
        List<String> inputs = Arrays.asList("123");
        assertStrikesEquals("123", inputs, 3);
    }

    @Test
    public void 스트라이크_1개() {
        List<String> inputs = Arrays.asList("145", "729", "683");
        assertStrikesEquals("123", inputs, 1);
    }

    @Test
    public void 스트라이크_2개() {
        List<String> inputs = Arrays.asList("125", "623", "193");
        assertStrikesEquals("123", inputs, 2);
    }

    @Test
    public void 스트라이트_전체테스트() {
        assertEquals(baseBallGameNumberComparator.getStrikesCount("123", "456"), 0);
        assertEquals(baseBallGameNumberComparator.getStrikesCount("567", "598"), 1);
        assertEquals(baseBallGameNumberComparator.getStrikesCount("236", "786"), 1);
        assertEquals(baseBallGameNumberComparator.getStrikesCount("478", "458"), 2);
        assertEquals(baseBallGameNumberComparator.getStrikesCount("369", "469"), 2);
        assertEquals(baseBallGameNumberComparator.getStrikesCount("854", "853"), 2);
        assertEquals(baseBallGameNumberComparator.getStrikesCount("456", "456"), 3);
    }

    private void assertStrikesEquals(String randomGenerated, List<String> inputs, int i) {
        for(String input : inputs)
            assertEquals(baseBallGameNumberComparator.getStrikesCount(randomGenerated, input), i);
    }
}
