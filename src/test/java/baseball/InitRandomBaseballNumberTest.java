package baseball;

import baseball.vo.RandomBaseballNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.temporal.ValueRange;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InitRandomBaseballNumberTest {

    RandomBaseballNumber randomBaseballNumber = new RandomBaseballNumber();

    @BeforeEach
    void initNumber() {
        randomBaseballNumber.initNumber();
    }

    @Test
    void 랜덤숫자는_세글자로_구성된다() {
        String randomNumber = randomBaseballNumber.getResultRandomNumber();
        assertEquals(randomNumber.length(), 3);
    }

    @Test
    void 랜덤숫자의_각자리수는_1부터9까지로_구성된다() {
        List<Integer> randomNumbers = randomBaseballNumber.getRandomNumbers();
        for (Integer number : randomNumbers) {
            boolean resultValidRange = ValueRange.of(1, 9).isValidIntValue(number);
            assertEquals(resultValidRange, true);
        }

    }

}
