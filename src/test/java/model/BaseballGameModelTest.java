package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BaseballGameModelTest {
    @Test
    void generateNumbers() {
        BaseballGameModel model = new BaseballGameModel();
        model.generateNumbers();
        int[] numbers = model.getBaseballNumbers();

        assertEquals(3, numbers.length);
        for (int number : numbers) {
            assertTrue(number >= 1 && number <= 9);
        }
    }

    @Test
    void compareNumbers() {
        // TODO: compareNumbers 메서드를 테스트하는 코드
    }
}
