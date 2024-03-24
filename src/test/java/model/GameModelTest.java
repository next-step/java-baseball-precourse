package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

class GameModelTest {

    GameModel gameModel;

    @BeforeEach
    void setUp() {
        gameModel = new GameModel();
    }

    @Test
    void testResetGameGeneratesValidNumbers() {
        gameModel.resetGame();
        int[] numbers = gameModel.getNumbers();

        for (int number : numbers) {
            Assertions.assertTrue(number >= 1 && number <= 9, "All numbers should be between 1 and 9.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            uniqueNumbers.add(number);
        }
        Assertions.assertEquals(3, uniqueNumbers.size(), "All numbers should be unique.");
    }

    @ParameterizedTest
    @CsvSource({
            "1 2 3, 3 0, 1 2 3",
            "1 2 3, 0 0, 4 5 6",
            "1 2 3, 1 2, 1 3 2",
            "1 2 3, 0 3, 2 3 1"
    })
    void testCalculateScore(String gameNumbers, String expectedScore, String guess) {
        GameModel gameModel = new GameModel();
        gameModel.setNumbers(convertStringToIntArray(gameNumbers));

        int[] guessedNumbers = convertStringToIntArray(guess);
        Score score = gameModel.calculateScore(guessedNumbers);

        int expectedStrikes = Integer.parseInt(expectedScore.split(" ")[0]);
        int expectedBalls = Integer.parseInt(expectedScore.split(" ")[1]);

        Assertions.assertEquals(expectedStrikes, score.getStrikes(), "Strikes did not match expected value.");
        Assertions.assertEquals(expectedBalls, score.getBalls(), "Balls did not match expected value.");
    }

    private int[] convertStringToIntArray(String input) {
        String[] items = input.split(" ");
        int[] result = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            result[i] = Integer.parseInt(items[i]);
        }
        return result;
    }
}