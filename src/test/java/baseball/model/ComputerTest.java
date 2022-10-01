package baseball.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class ComputerTest {
    @DisplayName("임의의 수 발생")
    @RepeatedTest(5)
    void 임의의_수_발생() {
        Computer computer1 = new Computer();
        Computer computer2 = new Computer();

        Assertions.assertFalse(computer1.getNumbers().containsAll(computer2.getNumbers()));
    }
}
