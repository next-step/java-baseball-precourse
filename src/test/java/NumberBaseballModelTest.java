import NumberBaseball.model.BaseBallCount;
import NumberBaseball.model.NumberBaseballModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestRandom extends Random {
    private final List<Integer> numbers;
    private final AtomicInteger index = new AtomicInteger(0);

    public TestRandom(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public int nextInt(int bound) {
        return numbers.get(index.getAndIncrement() % numbers.size());
    }
}

public class NumberBaseballModelTest {

    private NumberBaseballModel model;

    @BeforeEach
    void setUp() {
        TestRandom testRandom = new TestRandom(List.of(0, 1, 2));
        model = new NumberBaseballModel(testRandom);
    }

    @Test
    @DisplayName("Strike 3, Ball 0")
    void testCheckCountAllStrikes() {
        BaseBallCount count = model.checkCount(List.of("1", "2", "3"));
        assertThat(count.getStrike()).isEqualTo(3);
        assertThat(count.getBall()).isZero();
    }

    @Test
    @DisplayName("Strike 0, Ball 3")
    void testCheckCountNoMatches() {
        BaseBallCount count = model.checkCount(List.of("2", "3", "1"));
        assertThat(count.getStrike()).isZero();
        assertThat(count.getBall()).isEqualTo(3);
    }

    @Test
    @DisplayName("nothing matches")
    void testCheckCountNothingMatches() {
        BaseBallCount count = model.checkCount(List.of("4", "5", "6"));
        assertThat(count.getStrike()).isZero();
        assertThat(count.getBall()).isZero();
    }


    @Test
    @DisplayName("test game continuing")
    void testGameContinuing() {
        assertTrue(model.isGameContinuing());
        model.setGameContinuing(false);
        assertFalse(model.isGameContinuing());
    }

    @Test
    @DisplayName("test process restart option")
    void testProcessRestartOption() {
        model.processRestartOption("2");
        assertFalse(model.isGameContinuing());

        model.processRestartOption("1");
        assertTrue(model.isGameContinuing());
    }
}