package baseball.member;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {

    private static final int NUM_SIZE = 3;
    private static final String NUMBERS = "numbers";

    @Test
    void 랜덤한_3개의_숫자를_선택() throws Exception {
        Computer computer = new Computer();
        computer.choiceNumbers();

        Field field = computer.getClass().getDeclaredField(NUMBERS);
        field.setAccessible(true);

        List<Integer> numbers = (List<Integer>) field.get(computer);
        assertThat(numbers.size()).isEqualTo(NUM_SIZE);
    }
}
