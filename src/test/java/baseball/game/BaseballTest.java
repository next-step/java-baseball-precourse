package baseball.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BaseballTest {

    private static Baseball baseball;

    @BeforeAll
    static void setUp() {
        baseball = new Baseball();
    }

    @Test
    void validateInputNumbersTest() throws Throwable {
    	canOccurException(IllegalArgumentException.class, null);
    	canOccurException(IllegalArgumentException.class, "12");
    	canOccurException(IllegalArgumentException.class, "1234");
    	canOccurException(IllegalArgumentException.class, "102");
    	canOccurException(IllegalArgumentException.class, "922");
    	Assertions.assertDoesNotThrow(() -> baseball.validateInputNumbers("123"));
    }
    
    private <T extends Throwable> void canOccurException(Class<T> exception, String input) throws Throwable {
    	Assertions.assertThrows(exception, () -> baseball.validateInputNumbers(input));
    }

//    @Test
    void judgeResultTest(String userInput) {
    	baseball.judgeResult(userInput);
    }

}

