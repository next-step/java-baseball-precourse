package baseball.result;

import baseball.constants.Condition;
import baseball.constants.Regex;
import baseball.result.bean.Computer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("컴퓨터 생성 숫자 테스트")
public class ComputerNumberGeneratorTest {
    private ComputerNumberGenerator computerNumberGenerator;
    private Computer computer;
    @BeforeEach
    void setUp() {
        this.computerNumberGenerator = new ComputerNumberGenerator();
    }

    @DisplayName("랜덤 숫자 생성 테스트")
    @RepeatedTest(10)
    void generateComputerNumber() {
        this.computer = computerNumberGenerator.generateComputerNumber();

        List<Integer> actualComputerNumbers = this.computer.getNumbers();
        Set<Integer> actualSet = new HashSet<Integer>(actualComputerNumbers);
        boolean actual = actualSet.size() == Condition.DIGIT_LENGTH;

        assertThat(actual).isTrue();
    }
}