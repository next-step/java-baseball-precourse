package baseball;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
            Set<Character> sourceNumberSet = new LinkedHashSet<Character>(Arrays.asList('1','3','5'));
            List<Character> gameNumberSet= baseball.generateNumber();
            assertEquals(sourceNumberSet, gameNumberSet);
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
