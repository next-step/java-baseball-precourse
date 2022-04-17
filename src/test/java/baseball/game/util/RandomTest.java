package baseball.game.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {
    @Test
    @DisplayName("randomNumbers() 무작위 숫자가 오름차순일 때")
    void randomNumbers_Ascending() {
        assertRandomNumberInRangeTest(
                () -> {
                    List<Integer> result = Random.randomNumbers(9, 1, 9);
                    assertThat(result).hasSameElementsAs(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
                },
                1, 2, 3, 4, 5, 6, 7, 8, 9
        );
    }

    @Test
    @DisplayName("randomNumbers() 무작위 숫자가 내림차순일 때")
    void randomNumbers_Descending() {
        assertRandomNumberInRangeTest(
                () -> {
                    List<Integer> result = Random.randomNumbers(9, 1, 9);
                    assertThat(result).hasSameElementsAs(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1));
                },
                9, 8, 7, 6, 5, 4, 3, 2, 1
        );
    }

}
