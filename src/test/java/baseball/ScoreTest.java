package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ScoreTest {

    @Test
    void isNotDupl() {
        Score score = new Score(Arrays.asList("4","5","5"), Arrays.asList(1,2,3));
        assertFalse(score.isCorrectNums());
        score.printErrorMsgs();
    }

    @Test
    void isCorrectNums() {
        Score score = new Score(Arrays.asList("1","5"), Arrays.asList(1,2,3));
        assertFalse(score.isCorrectNums());
        score.printErrorMsgs();
    }

    @Test
    void isFail() {
        Score score = new Score(Arrays.asList("4","5","3"), Arrays.asList(1,2,3));
        score.printResult();
        assertFalse(score.isSuccess());
    }
}