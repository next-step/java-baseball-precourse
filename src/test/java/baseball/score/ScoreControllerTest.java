package baseball.score;

import baseball.model.Ball;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static baseball.score.Score.SELECT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ScoreControllerTest {
    ScoreController scoreController = new ScoreController();

    @Test
    void createBallCount() {
        ArrayList<String> ballCount = scoreController.createBallCount(new ArrayList<>());

        assertEquals(ballCount.size(), SELECT.num);
    }

    @Test
    void isNumber() {
        String str = "1가2나3다";
        boolean number = scoreController.isNumber(str);

        assertFalse(number);
    }

    @Test
    void compareValue() {
        ArrayList<String> arr1 = new ArrayList<>(Arrays.asList("1", "2", "3"));
        ArrayList<String> arr2 = new ArrayList<>(Arrays.asList("1", "2", "3"));
        Ball ball = scoreController.compareValue(new Ball(), arr1, arr2);

        assertEquals(ball.getStrike(), 3);
    }

}