package baseball.game;

import baseball.BaseTest;
import baseball.game.constant.GameRule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest extends BaseTest<GameResult> {

    private static GameResult gameResult;

    @BeforeAll
    public static void onlyOnce() {
        gameResult = new GameResult(GameRule.PICK_NUMBER_COUNT);
    }

    @ParameterizedTest
    @CsvSource({
            "123, 456, 0, 0",
            "123, 325, 1, 1",
            "123, 312, 0, 3",
            "123, 123, 3, 0",
    })
    void testCompare(String systemNumbers, String inputNumbers, int expectedStrikeCount, int expectedBallCount)
            throws InvocationTargetException, IllegalAccessException {
        Method method = super.getPrivateMethod(gameResult, "compare", String.class, String.class);
        method.invoke(gameResult, systemNumbers, inputNumbers);
        assertThat(expectedStrikeCount == gameResult.getStrikeCount()).isTrue();
        assertThat(expectedBallCount == gameResult.getBallCount()).isTrue();
        if(gameResult.getStrikeCount() == GameRule.PICK_NUMBER_COUNT) {
            assertThat(gameResult.isFinish()).isTrue();
        }
    }

    @ParameterizedTest
    @CsvSource({
            "3, true",
            "1, false",
            "2, false",
            "4, false",
    })
    void testIsFinish(int strikeCount, boolean expectedResult) throws InvocationTargetException, IllegalAccessException {
        Method method = super.getPrivateMethod(gameResult, "isFinish", int.class);
        boolean result = (boolean) method.invoke(gameResult, strikeCount);
        assertThat(result == expectedResult).isTrue();
    }

    @Test
    void testResetStrikeCount() throws InvocationTargetException, IllegalAccessException {
        int initStrikeCount = 0;
        int testStrikeCount = 2;
        super.setPrivateFieldValue(gameResult, "strikeCount", testStrikeCount);
        assertThat(gameResult.getStrikeCount() == testStrikeCount).isTrue();

        Method method = super.getPrivateMethod(gameResult, "resetStrikeCount");
        method.invoke(gameResult);
        assertThat(gameResult.getStrikeCount() == initStrikeCount).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 0",
            "1, 1, 1",
            "2, 0, 1",
            "2, 2, 2",
    })
    void testPlusCountIfIsStrike(char systemNumberChar, char inputNumberChar, int expectedStrikeCount)
            throws InvocationTargetException, IllegalAccessException {
        Method method = super.getPrivateMethod(gameResult, "plusCountIfIsStrike", char.class, char.class);
        method.invoke(gameResult, systemNumberChar, inputNumberChar);
        assertThat(expectedStrikeCount == gameResult.getStrikeCount()).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "123, 123, 3",
            "123, 456, 0",
            "153, 163, 2",
            "165, 123, 1",
    })
    void testCalculateStrikeCount(String systemNumbers, String numbers, int expectedStrikeCount)
            throws InvocationTargetException, IllegalAccessException {
        Method method = super.getPrivateMethod(gameResult, "calculateStrikeCount", String.class, String.class);
        method.invoke(gameResult, systemNumbers, numbers);
        assertThat(expectedStrikeCount == gameResult.getStrikeCount()).isTrue();
    }

    @Test
    void testResetBallCount() throws InvocationTargetException, IllegalAccessException {
        int initBallCount = 0;
        int testBallCount = 2;
        super.setPrivateFieldValue(gameResult, "ballCount", testBallCount);
        assertThat(gameResult.getBallCount() == testBallCount).isTrue();

        Method method = super.getPrivateMethod(gameResult, "resetBallCount");
        method.invoke(gameResult);
        assertThat(gameResult.getBallCount() == initBallCount).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "123, 1, 3, true",
            "123, 1, 4, false",
    })
    void testIsBall(String systemNumbers, int inputNumberIndex, char inputNumberChar, boolean expectedResult)
            throws InvocationTargetException, IllegalAccessException {
        Method method = super.getPrivateMethod(gameResult, "isBall", String.class, int.class, char.class);
        boolean isBall = (boolean) method.invoke(gameResult, systemNumbers, inputNumberIndex, inputNumberChar);
        assertThat(isBall == expectedResult).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "123, 1, 4, 0",
            "123, 1, 3, 1",
    })
    void testPlusCountIfIsBall(String systemNumbers, int inputNumberIndex, char inputNumberChar, int expectedBallCount)
            throws InvocationTargetException, IllegalAccessException {
        Method method = super.getPrivateMethod(gameResult, "plusCountIfIsBall", String.class, int.class, char.class);
        method.invoke(gameResult, systemNumbers, inputNumberIndex, inputNumberChar);
        assertThat(expectedBallCount == gameResult.getBallCount()).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "123, 456, 0",
            "123, 321, 2",
            "123, 312, 3",
            "123, 356, 1",
    })
    void testCalculateBallCount(String systemNumbers, String number, int expectedBallCount)
            throws InvocationTargetException, IllegalAccessException {
        Method method = super.getPrivateMethod(gameResult, "calculateBallCount", String.class, String.class);
        method.invoke(gameResult, systemNumbers, number);
        assertThat(expectedBallCount == gameResult.getBallCount()).isTrue();
    }


}