package baseball.game.console;

import baseball.BaseTest;
import baseball.game.constant.GameRule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class GameOverConsoleTest extends BaseTest<GameOverConsole> {

    private static GameOverConsole gameOverConsole;

    @BeforeAll
    public static void onlyOnce() {
        gameOverConsole = new GameOverConsole(GameRule.OVER_INPUT_NUMBER_LENGTH);
    }

    @ParameterizedTest
    @CsvSource({
            "1, true",
            "2, true",
            "3, false",
            "abc, false",
            "a, false",
            "abcd, false",
            "1234, false",
    })
    void testIsValidPolicy(String value, boolean expectedResult) throws InvocationTargetException, IllegalAccessException {
        Method method = super.getPrivateMethod(gameOverConsole, "isValidPolicy", String.class);
        boolean result = (boolean) method.invoke(gameOverConsole, value);
        assertThat(result == expectedResult).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "1, true",
            "2, true",
            "3, false",
            "abc, false",
            "a, false",
            "abcd, false",
            "1234, false",
    })
    void testIsKey(String value, boolean expectedResult) throws InvocationTargetException, IllegalAccessException {
        Method method = super.getPrivateMethod(gameOverConsole, "isKey", String.class);
        boolean result = (boolean) method.invoke(gameOverConsole, value);
        assertThat(result == expectedResult).isTrue();
    }
}