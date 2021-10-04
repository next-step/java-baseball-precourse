package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;


public class ComputerTest {

    private Computer computer;

    @BeforeEach
    void settings() {
        computer = new Computer();
    }

    @RepeatedTest(200)
    @DisplayName("컴퓨터의 야구게임 숫자가 잘 생성되는지 확인")
    void computerAnswerIsCorrect() {
        computer.generateBaseballNumber();

        assertThat(computer.getAnswerToInt()).isGreaterThan(122)
                .isLessThan(988)
                .isNotZero()
                .isPositive();

    }
}
