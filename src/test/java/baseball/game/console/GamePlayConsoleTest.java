package baseball.game.console;

import baseball.BaseTest;
import baseball.game.constant.GameRule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class GamePlayConsoleTest extends BaseTest<GamePlayConsole> {

    private static GamePlayConsole gamePlayConsole;

    @BeforeAll
    public static void onlyOnce() {
        gamePlayConsole = new GamePlayConsole(GameRule.PLAY_INPUT_NUMBER_LENGTH);
    }

    @ParameterizedTest
    @CsvSource({
            "123, true",
            "112, false",
            "abc, false",
            "a, false",
            "abcd, false",
            "1, false",
            "1234, false",
    })
    void testIsValidPolicy(String value, boolean expectedResult) throws InvocationTargetException, IllegalAccessException {
        Method method = super.getPrivateMethod(gamePlayConsole, "isValidPolicy", String.class);
        boolean result = (boolean) method.invoke(gamePlayConsole, value);
        assertThat(result == expectedResult).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "123, false",
            "112, true",
            "111, true",
    })
    void testContainSameNumber(String value, boolean expectedResult) throws InvocationTargetException, IllegalAccessException {
        Method method = super.getPrivateMethod(gamePlayConsole, "containSameNumber", String.class);
        boolean result = (boolean) method.invoke(gamePlayConsole, value);
        assertThat(result == expectedResult).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "123, true",
            "abc, false",
    })
    void testIsNumber(String value, boolean expectedResult) throws InvocationTargetException, IllegalAccessException {
        Method method = super.getPrivateMethod(gamePlayConsole, "isNumber", String.class);
        boolean result = (boolean) method.invoke(gamePlayConsole, value);
        assertThat(result == expectedResult).isTrue();
    }


}