package baseball.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComputerTest {

    @Test
    void computerInitTest() {
        Computer computer = new Computer();
        List<Integer> createdNumbers = computer.getNumbers();

        Assertions.assertThat(createdNumbers).doesNotHaveDuplicates();
        Assertions.assertThat(createdNumbers.size()).isEqualTo(3);
    }
}
