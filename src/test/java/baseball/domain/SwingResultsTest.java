package baseball.domain;

import baseball.utils.RandomNumbersFixedProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class SwingResultsTest {

    private List<Integer> randomNumbers;
    private Swing swing;

    @BeforeEach
    void randomNumbers() {
        randomNumbers = RandomNumbersFixedProvider.randomNumberCreate();
        swing = new Swing();
    }

    @Test
    void 출력문구_낫싱() {
        // given
        swing.swinged(randomNumbers, Arrays.asList(2, 4, 6));
        // when
        String printMessage = SwingResults.printMessage(swing);
        // then
        Assertions.assertEquals("낫싱", printMessage);
    }

    @Test
    void 출력문구_3스트라이크() {
        // given
        swing.swinged(randomNumbers, Arrays.asList(1, 3, 5));
        // when
        String printMessage = SwingResults.printMessage(swing);
        // then
        Assertions.assertEquals("3스트라이크", printMessage);
    }

    @Test
    void 출력문구_3볼() {
        // given
        swing.swinged(randomNumbers, Arrays.asList(5, 1, 3));
        // when
        String printMessage = SwingResults.printMessage(swing);
        // then
        Assertions.assertEquals("3볼", printMessage);
    }

    @Test
    void 출력문구_2볼_1스트라이크() {
        // given
        swing.swinged(randomNumbers, Arrays.asList(1, 5, 3));
        // when
        String printMessage = SwingResults.printMessage(swing);
        // then
        Assertions.assertEquals("2볼 1스트라이크", printMessage);
    }

}