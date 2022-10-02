package baseball.domain;

import baseball.utils.RandomNumbersFixedProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class SwingTest {

    private List<Integer> randomNumbers;
    private Swing swing;

    @BeforeEach
    void randomNumbers() {
        // given
        randomNumbers = RandomNumbersFixedProvider.randomNumberCreate();
        swing = new Swing();
    }

    @Test
    void 스트라이크_3개() {
        // when
        swing.swinged(randomNumbers, Arrays.asList(1, 3, 5));
        // then
        Assertions.assertEquals(swing.getStrike(), 3);
        Assertions.assertEquals(swing.getBall(), 0);
    }

    @Test
    void 스트라이크_1개_볼_2개() {
        // when
        swing.swinged(randomNumbers, Arrays.asList(1, 5, 3));
        // then
        Assertions.assertEquals(swing.getStrike(), 1);
        Assertions.assertEquals(swing.getBall(), 2);
    }

    @Test
    void 볼_3개() {
        // when
        swing.swinged(randomNumbers, Arrays.asList(5, 1, 3));
        // then
        Assertions.assertEquals(swing.getStrike(), 0);
        Assertions.assertEquals(swing.getBall(), 3);
    }

    @Test
    void 낫싱() {
        // when
        swing.swinged(randomNumbers, Arrays.asList(7, 8, 9));
        // then
        Assertions.assertEquals(swing.getStrike(), 0);
        Assertions.assertEquals(swing.getBall(), 0);
    }

}