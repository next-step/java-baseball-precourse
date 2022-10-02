package baseball.domain;

import baseball.utils.RandomNumbersFixedProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class StrikeWinneTest {

    private List<Integer> randomNumbers;
    private Swing swing;
    private WinneStrategy winneStrategy;

    @BeforeEach
    void randomNumbers() {
        randomNumbers = RandomNumbersFixedProvider.randomNumberCreate();
        swing = new Swing();
        winneStrategy = new StrikeWinne();
    }

    @Test
    void 스트라이크3번_승리() {
        // given
        swing.swinged(randomNumbers, Arrays.asList(1, 3, 5));
        // when
        boolean winne = winneStrategy.winne(swing);
        // then
        Assertions.assertEquals(winne, true);
    }

    @Test
    void 스트라이크3번이아닐경우_실패() {
        // given
        swing.swinged(randomNumbers, Arrays.asList(1, 7, 5));
        // when
        boolean winne = winneStrategy.winne(swing);
        // then
        Assertions.assertEquals(winne, false);
    }
}