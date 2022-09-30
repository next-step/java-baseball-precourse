package baseball.model.computer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ComputerTest {
    @Test
    @DisplayName("3자리_숫자_생성테스트")
    void generateRandomTest() {
        Computer computer = new Computer();

        String computerBall = computer.getBall();
        assertThat(computerBall).hasSize(3);
        assertThat(Character.getNumericValue(computerBall.charAt(0))).isBetween(0, 9);
        assertThat(Character.getNumericValue(computerBall.charAt(1))).isBetween(0, 9);
        assertThat(Character.getNumericValue(computerBall.charAt(2))).isBetween(0, 9);
    }
}
