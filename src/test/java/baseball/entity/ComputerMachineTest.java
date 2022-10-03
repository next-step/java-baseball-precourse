package baseball.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerMachineTest {

    private ComputerMachine computerMachine;
    private List<Integer> threeOtherNumbers;

    @BeforeEach
    public void setUp() {
        computerMachine = new ComputerMachine();
        threeOtherNumbers = computerMachine.makeThreeNumbers();
    }

    @DisplayName("숫자 3개 입력 테스트")
    @Test
    public void getRandomThreeNumberTest() {
        assertThat(threeOtherNumbers.size()).isEqualTo(3);
    }
}
