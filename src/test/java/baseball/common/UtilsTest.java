package baseball.common;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UtilsTest {
    @Test
    @DisplayName("int array 최댓값")
    void max_test(){
        int[] array = new int[] {1, 3, 5, 10, -20, 0};
        assertThat(Utils.maxOf(array)).isEqualTo(10);
    }

    @Test
    @DisplayName("int array 최솟값")
    void min_test(){
        int[] array = new int[] {1, 3, 5, 10, -20, 0};
        assertThat(Utils.minOf(array)).isEqualTo(-20);
    }
}
