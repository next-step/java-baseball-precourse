package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ComputerTest {

    @DisplayName("컴퓨터의 공던지기를 실행하면 임의 숫자값이 나온다")
    @Test
    void throwBallsEmpty() {
        // given
        Computer computer = new Computer();

        // when
        computer.throwBalls();
        HashSet<Integer> ballCounts = computer.getBallCount();

        // then
        assertTrue(!ballCounts.isEmpty());
        assertTrue(ballCounts.size() == computer.getBallCountLength());
    }

    @DisplayName("컴퓨터의 공던지기를 실행하면 임의 숫자값이 나온다")
    @Test
    void throwBallsLength() {
        // given
        Computer computer = new Computer();

        // when
        computer.throwBalls();
        HashSet<Integer> ballCounts = computer.getBallCount();

        // then
        assertTrue(ballCounts.size() == computer.getBallCountLength());
    }
}