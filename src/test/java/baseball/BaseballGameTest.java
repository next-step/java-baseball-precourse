package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTest {
    private static final int TEST_SIZE = 10000;

    @Test
    void generateGameAnswer_has_size_three() {
        for (int i = 0; i < TEST_SIZE; i++) {
            int[] result = BaseballGame.generateGameAnswer();
            assertThat(result).hasSize(3);
        }
    }

    @Test
    void generateGameAnswer_consist_of_distinct_number() {
        for (int i = 0; i < TEST_SIZE; i++) {
            int[] result = BaseballGame.generateGameAnswer();
            List<Integer> numberList = Arrays.stream(result).boxed().collect(Collectors.toList());
            assertThat(numberList).doesNotHaveDuplicates();
        }
    }

    @Test
    void generateGameAnswer_consist_of_1_to_9() {
        for (int i = 0; i < TEST_SIZE; i++) {
            int[] result = BaseballGame.generateGameAnswer();
            assertThat(result[0]).isGreaterThanOrEqualTo(1);
            assertThat(result[0]).isLessThanOrEqualTo(9);
            assertThat(result[1]).isGreaterThanOrEqualTo(1);
            assertThat(result[1]).isLessThanOrEqualTo(9);
            assertThat(result[2]).isGreaterThanOrEqualTo(1);
            assertThat(result[2]).isLessThanOrEqualTo(9);
        }
    }

    @Test
    void isFinished() {

    }

    @Test
    void isValid() {
    }

    @Test
    void grade() {
    }

    @Test
    void nonMatch() {
    }

    @Test
    void allMatch() {
    }

    @Test
    void getStrikeCount() {
    }

    @Test
    void getBallCount() {
    }
}
