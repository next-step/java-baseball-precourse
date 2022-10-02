package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static baseball.constant.BaseballProperties.GAME_SIZE;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @Test
    @DisplayName("컴퓨터가 만든 정답은 중복값이 없는 GAME_SIZE 길이의 숫자다")
    void test() {
        Computer computer = new Computer();
        computer.shuffle();

        List<Ball> answer = computer.getAnswer();

        Set<Integer> checkSet = new HashSet<>();

        for(Ball ball : answer) {
            checkSet.add(ball.getValue());
        }

        assertEquals(GAME_SIZE, checkSet.size());
    }

}