package baseball.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameServiceTest {

    @Test
    @DisplayName("중복 숫자가 없는지 확인")
    void notDuplicationNumber() {
        assertEquals(
                9,
                GameService.pickRandomNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8))
        );
    }
}