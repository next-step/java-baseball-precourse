package baseball.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ComputerTest {

    @Test
    public void 숫자_생성_테스트() {
        Computer computer = new Computer();
        List<Integer> answers = computer.getNumbers();
        Assertions.assertEquals(3, answers.size());
    }
}
