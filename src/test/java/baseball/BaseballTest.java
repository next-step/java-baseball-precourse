package baseball;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class BaseballTest {
    Baseball baseball;
    @BeforeEach
    void setUp() {
        baseball = new Baseball();
    }

    @Test
    void startGame() {
    }

    @Test
    void generateNumber() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            char[] sourceNumber = {'1','3','5'};
            char[] gameNumber = baseball.generateNumber();
            assertArrayEquals(sourceNumber, gameNumber);
        }
    }

    @Test
    void inputNumber() {
    }

    @Test
    void checkNumber() {
    }

    @Test
    void makeResultString() {
    }

    @Test
    void endGame() {
    }
}
