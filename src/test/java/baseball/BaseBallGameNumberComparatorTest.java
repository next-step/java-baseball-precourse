package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseBallGameNumberComparatorTest {

    private BaseBallGameNumberComparator baseBallGameNumberComparator;

    @BeforeEach
    void setUp() {
        baseBallGameNumberComparator = new BaseBallGameNumberComparator(BaseBallGame.DEFAULT_LENGTH);
    }

    @Test
    public void 결과_반환() {
        assertArrayEquals(baseBallGameNumberComparator.getBaseBallGameResult("123", "123"), new int[]{3, 0});
        assertArrayEquals(baseBallGameNumberComparator.getBaseBallGameResult("123", "132"), new int[]{1, 2});
        assertArrayEquals(baseBallGameNumberComparator.getBaseBallGameResult("123", "159"), new int[]{1, 0});
        assertArrayEquals(baseBallGameNumberComparator.getBaseBallGameResult("829", "129"), new int[]{2, 0});
        assertArrayEquals(baseBallGameNumberComparator.getBaseBallGameResult("789", "897"), new int[]{0, 3});
        assertArrayEquals(baseBallGameNumberComparator.getBaseBallGameResult("789", "197"), new int[]{0, 2});
        assertArrayEquals(baseBallGameNumberComparator.getBaseBallGameResult("123", "456"), new int[]{0, 0});
    }


    @Test
    public void 볼_3개() {
        List<String> inputs = Arrays.asList("312", "231");
        assertBallEquals("123", inputs, 3);
    }

    @Test
    public void 볼_2개() {
        List<String> inputs = Arrays.asList("912", "234", "531", "251", "912", "318");
        assertBallEquals("123", inputs, 2);
    }

    @Test
    public void 볼_1개() {
        List<String> inputs = Arrays.asList("917", "264", "539", "451", "962", "378");
        assertBallEquals("123", inputs, 1);
    }

    @Test
    public void 볼_0개() {
        List<String> inputs = Arrays.asList("456");
        assertBallEquals("123", inputs, 0);
    }

    @Test
    public void 볼_전체테스트() {
        assertEquals(baseBallGameNumberComparator.getBallsCount("123", "456"), 0);
        assertEquals(baseBallGameNumberComparator.getBallsCount("567", "689"), 1);
        assertEquals(baseBallGameNumberComparator.getBallsCount("154", "563"), 1);
        assertEquals(baseBallGameNumberComparator.getBallsCount("687", "865"), 2);
        assertEquals(baseBallGameNumberComparator.getBallsCount("145", "459"), 2);
        assertEquals(baseBallGameNumberComparator.getBallsCount("256", "621"), 2);
        assertEquals(baseBallGameNumberComparator.getBallsCount("987", "798"), 3);
    }


    private void assertBallEquals(String randomGenerated, List<String> inputs, int ballsCount) {
        for ( String input : inputs )
            assertEquals(baseBallGameNumberComparator.getBallsCount(randomGenerated, input), ballsCount);
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

    @Test
    public void 스트라이크_2개() {
        List<String> inputs = Arrays.asList("125", "623", "193");
        assertStrikesEquals("123", inputs, 2);
    }

    @Test
    public void 스트라이크_1개() {
        List<String> inputs = Arrays.asList("145", "729", "683");
        assertStrikesEquals("123", inputs, 1);
    }

    @Test
    public void 스트라이크_3개() {
        List<String> inputs = Arrays.asList("123");
        assertStrikesEquals("123", inputs, 3);
    }

    private void assertStrikesEquals(String randomGenerated, List<String> inputs, int i) {
        for(String input : inputs)
            assertEquals(baseBallGameNumberComparator.getStrikesCount(randomGenerated, input), i);
    }
}
