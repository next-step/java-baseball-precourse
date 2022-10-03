package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ComputerTest {
    @Test
    void 리셋후_랜덤숫자_가져오기_테스트() {
        Computer computer = Computer.getInstance();
        String previousNumber = computer.getNumber();
        computer.reset();
        assertThat(computer.getNumber()).isNotEqualTo(previousNumber);
    }
}