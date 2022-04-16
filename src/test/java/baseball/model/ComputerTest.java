package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class ComputerTest {
    private Computer computer = new Computer();

    @Test
    void generateRandomNumber() {
        computer.generateRandomNumber();
        Set<Integer> number = computer.getNumber();
        assertThat(number).hasSize(3).doesNotHaveDuplicates().doesNotContain(0);
    }
}