package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputerTest {
    private Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer();
    }

    @Test
    void 컴퓨터는_생성시_공을_보유하고_있다() {
        Balls computerHasBalls = computer.getHasBalls();
        assertThat(computerHasBalls).isNotNull();
    }

    @Test
    void 컴퓨터는_3개의_공을_보유하고_있다() {
        Balls computerHasBalls = computer.getHasBalls();
        for (int i = 0; i < 3; i++) {
            assertThat(computerHasBalls.getBall(i)).isNotNull();
        }
    }

    @Test
    void 컴퓨터가_보유한_공은_중복되지_않는다() {
        Balls computerHasBalls = computer.getHasBalls();
        Set<Ball> duplicateCheckSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            Ball ball = computerHasBalls.getBall(i);
            duplicateCheckSet.add(ball);
        }
        assertThat(duplicateCheckSet.size()).isEqualTo(3);
    }
}
