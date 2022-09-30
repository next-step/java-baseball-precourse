package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerBallsTest {

    private ComputerBalls computerBalls;

    @BeforeEach
    void setUp() {
        computerBalls = new ComputerBalls();
    }

    @Test
    @DisplayName("컴퓨터 볼이 세자리가 맞는지 테스트")
    void isComputerBallsHasRightLength() {
        assertThat(BallValidator.isInputHasRightLength(computerBalls.getBalls())).isTrue();
    }

    @Test
    @DisplayName("컴퓨터 볼이 1부터 9까지의 숫자로만 이루어져 있는지 테스트")
    void isComputerBallsContainsOnlyOneToNine() {
        assertThat(BallValidator.isInputContainsOnlyOneToNine(computerBalls.getBalls())).isTrue();
    }

    @Test
    @DisplayName("컴퓨터 볼이 서로 다른 수로 이루어져 있는지 테스트")
    void isComputerBallsContainOfUniqueNumber() {
        assertThat(BallValidator.isInputContainsUniqueNumbers(computerBalls.getBalls())).isTrue();
    }

}